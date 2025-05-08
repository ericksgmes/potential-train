package com.pw3.infrastructure.conserto;

import com.pw3.domain.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
}
