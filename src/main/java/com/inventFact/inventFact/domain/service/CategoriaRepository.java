package com.inventFact.inventFact.domain.service;

import com.inventFact.inventFact.domain.entity.Categoria;

import java.util.List;

public interface CategoriaRepository{
    List<Categoria> findAll();
    Categoria findById(Long id);
    Categoria save(Categoria producto);
    void delete(Long id);
}
