package com.inventFact.inventFact.application.service.mongo;

import com.inventFact.inventFact.domain.mongo.entity.FacturasProveedoresMongo;
import com.inventFact.inventFact.infrastructure.mongo.repository.FacturasProveedoresMongoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturasProveedoresMongoService {
    private final FacturasProveedoresMongoRepository repository;

    public FacturasProveedoresMongoService(FacturasProveedoresMongoRepository repository) {
        this.repository = repository;
    }

    public List<FacturasProveedoresMongo> findAll() {
        return repository.findAll();
    }

    public FacturasProveedoresMongo save(FacturasProveedoresMongo factura) {
        return repository.save(factura);
    }

    // Otros métodos CRUD si los necesitas
}
