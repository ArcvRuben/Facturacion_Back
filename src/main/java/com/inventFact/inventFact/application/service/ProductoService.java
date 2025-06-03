package com.inventFact.inventFact.application.service;

import com.inventFact.inventFact.domain.entity.Producto;
import com.inventFact.inventFact.domain.service.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService{

    private final ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public List<Producto> findAllVisible(Long id){
        return productoRepository.findAllVisible();
    }

    public Producto findByNombre(String nombre){
        return productoRepository.findByNombreProducto(nombre);
    }

    public Producto findById(Long id){
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto){
        return  productoRepository.save(producto);
    }

    public void delete(Long id){
        productoRepository.delete(id);
    }
}
