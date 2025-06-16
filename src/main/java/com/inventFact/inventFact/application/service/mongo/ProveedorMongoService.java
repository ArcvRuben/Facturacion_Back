package com.inventFact.inventFact.application.service.mongo;

import com.inventFact.inventFact.domain.mongo.entity.ProveedorMongo;
import com.inventFact.inventFact.infrastructure.mongo.repository.ProveedorMongoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorMongoService {
    private final ProveedorMongoRepository repository;

    public ProveedorMongoService(ProveedorMongoRepository repository) {
        this.repository = repository;
    }

    public List<ProveedorMongo> findAll() {
        return repository.findAll();
    }

    public ProveedorMongo save(ProveedorMongo proveedor) {
        return repository.save(proveedor);
    }

    // Otros métodos CRUD si los necesitas
}
