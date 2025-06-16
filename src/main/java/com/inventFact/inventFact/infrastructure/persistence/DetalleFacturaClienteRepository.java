package com.inventFact.inventFact.infrastructure.persistence;


import com.inventFact.inventFact.domain.entity.DetalleFacturaCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaClienteRepository extends JpaRepository<DetalleFacturaCliente, Long> {}
