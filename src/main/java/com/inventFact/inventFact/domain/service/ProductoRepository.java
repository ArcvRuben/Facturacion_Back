package com.inventFact.inventFact.domain.service;

import com.inventFact.inventFact.domain.entity.Producto;

import java.util.List;

public interface ProductoRepository  {

    List<Producto> findAll();
    List<Producto> findAllVisible();
    Producto findByNombreProducto(String nombreProducto);
    Producto findById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
}
