package com.inventFact.inventFact.domain.service;
import com.inventFact.inventFact.domain.entity.FacturasProveedores;
import com.inventFact.inventFact.domain.entity.Producto;

import java.util.List;

public interface FacturasProveedoresRepository {
    List<FacturasProveedores> findAll();
    List<FacturasProveedores> findAllVisible();
    FacturasProveedores findById(Long id);
    FacturasProveedores save(FacturasProveedores facturasProveedores);
}
