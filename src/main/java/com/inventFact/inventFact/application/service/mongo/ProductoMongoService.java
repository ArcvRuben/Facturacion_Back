package com.inventFact.inventFact.application.service.mongo;

import com.inventFact.inventFact.domain.mongo.entity.ProductoMongo;
import com.inventFact.inventFact.infrastructure.mongo.repository.ProductoMongoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoMongoService {
    private final ProductoMongoRepository repository;

    public ProductoMongoService(ProductoMongoRepository repository) {
        this.repository = repository;
    }

    public List<ProductoMongo> findAll() {
        return repository.findAll();
    }

    public ProductoMongo save(ProductoMongo producto) {
        return repository.save(producto);
    }

    // Otros métodos CRUD si los necesitas
}
