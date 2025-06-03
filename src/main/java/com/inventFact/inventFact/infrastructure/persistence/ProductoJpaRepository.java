package com.inventFact.inventFact.infrastructure.persistence;

import com.inventFact.inventFact.domain.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoJpaRepository  extends JpaRepository<Producto,Long> {
    List<Producto> findByVisibleTrue();
    Producto findByNombreProducto(String nombreProducto);
}
