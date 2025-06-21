package com.inventFact.inventFact.application.service.mongo;

import com.inventFact.inventFact.domain.mongo.entity.ProductoMongo;
import com.inventFact.inventFact.infrastructure.mongo.repository.ProductoMongoRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoMongoService {
    private final ProductoMongoRepository repository;

    public ProductoMongoService(ProductoMongoRepository repository) {
        this.repository = repository;
    }

    public List<ProductoMongo> findAll() {
        return repository.findAll();
    }

    public Optional<ProductoMongo> findById(String id) {
        return repository.findById(id);
    }

    public ProductoMongo save(ProductoMongo producto) {
        if (producto.getFechaIngreso() == null) {
            producto.setFechaIngreso(new Date());
        }
        return repository.save(producto);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
