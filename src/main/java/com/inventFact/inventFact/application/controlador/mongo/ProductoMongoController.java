package com.inventFact.inventFact.application.controlador.mongo;

import com.inventFact.inventFact.application.service.mongo.ProductoMongoService;
import com.inventFact.inventFact.domain.mongo.entity.ProductoMongo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mongo/productos")
public class ProductoMongoController {
    private final ProductoMongoService service;

    public ProductoMongoController(ProductoMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductoMongo> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ProductoMongo create(@RequestBody ProductoMongo producto) {
        return service.save(producto);
    }

    // Otros endpoints si los necesitas
}
