package com.inventFact.inventFact.infrastructure.persistence;

import com.inventFact.inventFact.domain.entity.FacturasProveedores;
import com.inventFact.inventFact.domain.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturasProveedoresJpaRepository extends JpaRepository<FacturasProveedores,Long> {

    List<FacturasProveedores> findByVisibleTrue();
}
