package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.domain.entity.FacturasProveedores;
import com.inventFact.inventFact.domain.entity.Producto;
import com.inventFact.inventFact.domain.service.FacturasProveedoresRepository;
import com.inventFact.inventFact.infrastructure.persistence.FacturasProveedoresJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class FacturasProveedoresJpaAdapter implements FacturasProveedoresRepository {

    private final FacturasProveedoresJpaRepository facturasProveedoresJpaRepository;

    @Override
    public List<FacturasProveedores> findAll() {
        return facturasProveedoresJpaRepository.findAll();
    }

    @Override
    public List<FacturasProveedores> findAllVisible() {
        return facturasProveedoresJpaRepository.findByVisibleTrue();
    }

    @Override
    public FacturasProveedores findById(Long id) {
        return facturasProveedoresJpaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Factura no encontrada"));
    }

    @Override
    public FacturasProveedores save(FacturasProveedores facturasProveedores) {
        return facturasProveedoresJpaRepository.save(facturasProveedores);
    }
}
