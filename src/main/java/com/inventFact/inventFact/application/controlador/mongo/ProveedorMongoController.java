package com.inventFact.inventFact.application.controlador.mongo;

import com.inventFact.inventFact.application.service.mongo.ProveedorMongoService;
import com.inventFact.inventFact.domain.mongo.entity.ProveedorMongo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mongo/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorMongoController {
    private final ProveedorMongoService service;

    public ProveedorMongoController(ProveedorMongoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProveedorMongo>> getAll() {
        List<ProveedorMongo> proveedores = service.findAll();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorMongo> getById(@PathVariable String id) {
        Optional<ProveedorMongo> proveedor = service.findById(id);
        return proveedor.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProveedorMongo> create(@RequestBody ProveedorMongo proveedor) {
        try {
            ProveedorMongo nuevoProveedor = service.save(proveedor);
            return ResponseEntity.ok(nuevoProveedor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorMongo> update(@PathVariable String id, @RequestBody ProveedorMongo proveedor) {
        try {
            Optional<ProveedorMongo> proveedorExistente = service.findById(id);
            if (proveedorExistente.isPresent()) {
                proveedor.setId(id);
                ProveedorMongo proveedorActualizado = service.save(proveedor);
                return ResponseEntity.ok(proveedorActualizado);
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
            Optional<ProveedorMongo> proveedor = service.findById(id);
            if (proveedor.isPresent()) {
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
