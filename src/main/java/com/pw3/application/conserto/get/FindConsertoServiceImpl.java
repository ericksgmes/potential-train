package com.pw3.application.conserto.get;

import com.pw3.util.ConsertoNotFoundException;
import com.pw3.domain.conserto.Conserto;
import com.pw3.infrastructure.conserto.ConsertoDto;
import com.pw3.infrastructure.conserto.ConsertoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class FindConsertoServiceImpl implements FindConsertoService {

    private final ConsertoRepository consertoRepository;

    public FindConsertoServiceImpl(ConsertoRepository consertoRepository) {
        this.consertoRepository = consertoRepository;
    }

    @Override
    public ResponseEntity<Page<ConsertoDto>> listarAtivos(Pageable pageable) {
        Page<ConsertoDto> pageDto = consertoRepository
                .findAllByAtivoTrue(pageable)
                .map(ConsertoDto::fromDomain);
        return ResponseEntity.ok(pageDto);
    }

    @Override
    public ResponseEntity<ConsertoDto> buscarPorId(Long id) {
        Conserto conserto = consertoRepository
                .findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ConsertoNotFoundException(id));

        ConsertoDto dto = ConsertoDto.fromDomain(conserto);
        return ResponseEntity.ok(dto);
    }
}
