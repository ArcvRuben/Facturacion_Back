package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.domain.entity.Proveedor;
import com.inventFact.inventFact.domain.service.ProveedorRepository;
import com.inventFact.inventFact.infrastructure.persistence.ProveedorJpaRespository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class ProveedorJpaAdapter implements ProveedorRepository {

    private final ProveedorJpaRespository proveedorJpaRespository;

    @Override
    public List<Proveedor> findAll() {
        return proveedorJpaRespository.findAll();
    }

    @Override
    public Proveedor findById(Long id) {
        return proveedorJpaRespository.findById(id).orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado"));
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorJpaRespository.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        proveedorJpaRespository.deleteById(id);
    }
}
