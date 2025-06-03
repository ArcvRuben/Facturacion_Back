package com.inventFact.inventFact.domain.service;
import com.inventFact.inventFact.domain.entity.Proveedor;

import java.util.List;

public interface ProveedorRepository {
    List<Proveedor> findAll();
    Proveedor findById(Long id);
    Proveedor save(Proveedor proveedor);
    void delete(Long id);
}
