package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.domain.entity.Categoria;
import com.inventFact.inventFact.domain.service.CategoriaRepository;
import com.inventFact.inventFact.infrastructure.persistence.CategoriaJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class CategoriaJpaAdapter implements CategoriaRepository {

    private final CategoriaJpaRepository categoriaJpaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaJpaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
    }

    @Override
    public Categoria save(Categoria producto) {
        return categoriaJpaRepository.save(producto);
    }

    @Override
    public void delete(Long id) {
        categoriaJpaRepository.deleteById(id);
    }
}
