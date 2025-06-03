package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.domain.entity.Producto;
import com.inventFact.inventFact.domain.service.ProductoRepository;
import com.inventFact.inventFact.infrastructure.persistence.ProductoJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class ProductoJpaAdapter implements ProductoRepository {

    private final ProductoJpaRepository productoJpaRepository;

    @Override
    public List<Producto> findAll() {
        return productoJpaRepository.findAll();
    }

    @Override
    public List<Producto> findAllVisible() {
        return productoJpaRepository.findByVisibleTrue();
    }

    @Override
    public Producto findByNombreProducto(String nombreProducto) {
        return productoJpaRepository.findByNombreProducto(nombreProducto);
    }

    @Override
    public Producto findById(Long id) {
        return productoJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
    }

    @Override
    public Producto save(Producto producto) {
        return productoJpaRepository.save(producto);
    }

    @Override
    public void delete(Long id) {
        Producto producto = productoJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        productoJpaRepository.deleteById(id);
    }
}