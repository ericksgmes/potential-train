package com.pw3.application.conserto.delete;

import com.pw3.domain.conserto.Conserto;
import com.pw3.infrastructure.conserto.ConsertoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteConsertoServiceImpl implements DeleteConsertoService {

    private final ConsertoRepository consertoRepository;

    public DeleteConsertoServiceImpl(ConsertoRepository consertoRepository) {
        this.consertoRepository = consertoRepository;
    }

    @Override
    public void delete(Long id) {
        Conserto conserto = consertoRepository
                .findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Conserto não encontrado com id " + id));

        // marca como inativo
        conserto.excluir();

        // persiste a mudança
        consertoRepository.save(conserto);
    }
}
