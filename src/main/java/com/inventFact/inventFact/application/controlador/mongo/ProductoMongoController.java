package com.inventFact.inventFact.application.controlador.mongo;

import com.inventFact.inventFact.application.service.mongo.ProductoMongoService;
import com.inventFact.inventFact.domain.mongo.entity.ProductoMongo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mongo/productos")
@CrossOrigin(origins = "*")
public class ProductoMongoController {
    private final ProductoMongoService service;

    public ProductoMongoController(ProductoMongoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductoMongo>> getAll() {
        List<ProductoMongo> productos = service.findAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoMongo> getById(@PathVariable String id) {
        Optional<ProductoMongo> producto = service.findById(id);
        return producto.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoMongo> create(@RequestBody ProductoMongo producto) {
        try {
            ProductoMongo nuevoProducto = service.save(producto);
            return ResponseEntity.ok(nuevoProducto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoMongo> update(@PathVariable String id, @RequestBody ProductoMongo producto) {
        try {
            Optional<ProductoMongo> productoExistente = service.findById(id);
            if (productoExistente.isPresent()) {
                producto.setId(id);
                ProductoMongo productoActualizado = service.save(producto);
                return ResponseEntity.ok(productoActualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            Optional<ProductoMongo> producto = service.findById(id);
            if (producto.isPresent()) {
                service.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
