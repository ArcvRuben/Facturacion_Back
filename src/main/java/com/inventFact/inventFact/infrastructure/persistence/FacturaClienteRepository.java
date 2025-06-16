package com.inventFact.inventFact.infrastructure.persistence;

import com.inventFact.inventFact.domain.entity.FacturaCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaClienteRepository extends JpaRepository<FacturaCliente, Long> {

}

