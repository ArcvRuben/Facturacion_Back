package com.inventFact.inventFact.infrastructure.persistence;

import com.inventFact.inventFact.domain.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorJpaRespository extends JpaRepository<Proveedor,Long> {
}
