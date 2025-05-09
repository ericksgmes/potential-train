package com.pw3.infrastructure.conserto;

import com.pw3.domain.conserto.Conserto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    Page<Conserto> findAllByAtivoTrue(Pageable pageable);

    Optional<Conserto> findByIdAndAtivoTrue(Long id);
}
