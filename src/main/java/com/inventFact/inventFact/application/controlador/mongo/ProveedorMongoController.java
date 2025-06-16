package com.inventFact.inventFact.application.controlador.mongo;

import com.inventFact.inventFact.application.service.mongo.ProveedorMongoService;
import com.inventFact.inventFact.domain.mongo.entity.ProveedorMongo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mongo/proveedores")
public class ProveedorMongoController {
    private final ProveedorMongoService service;

    public ProveedorMongoController(ProveedorMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProveedorMongo> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ProveedorMongo create(@RequestBody ProveedorMongo proveedor) {
        return service.save(proveedor);
    }

    // Otros endpoints si los necesitas
}
