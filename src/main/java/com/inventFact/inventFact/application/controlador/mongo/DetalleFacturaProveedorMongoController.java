package com.inventFact.inventFact.application.controlador.mongo;

import com.inventFact.inventFact.domain.mongo.entity.DetalleFacturaProveedorMongo;
import com.inventFact.inventFact.application.service.mongo.DetalleFacturaProveedorMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mongo/detalle-factura-proveedor")
@CrossOrigin(origins = "*")
public class DetalleFacturaProveedorMongoController {

    @Autowired
    private DetalleFacturaProveedorMongoService detalleService;

    @GetMapping
    public ResponseEntity<List<DetalleFacturaProveedorMongo>> getAllDetalles() {
        List<DetalleFacturaProveedorMongo> detalles = detalleService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFacturaProveedorMongo> getDetalleById(@PathVariable String id) {
        Optional<DetalleFacturaProveedorMongo> detalle = detalleService.findById(id);
        return detalle.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/factura/{facturaId}")
    public ResponseEntity<List<DetalleFacturaProveedorMongo>> getDetallesByFacturaId(@PathVariable String facturaId) {
        List<DetalleFacturaProveedorMongo> detalles = detalleService.findByFacturaId(facturaId);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<DetalleFacturaProveedorMongo>> getDetallesByProductoId(@PathVariable String productoId) {
        List<DetalleFacturaProveedorMongo> detalles = detalleService.findByProductoId(productoId);
        return ResponseEntity.ok(detalles);
    }

    @PostMapping
    public ResponseEntity<DetalleFacturaProveedorMongo> createDetalle(@RequestBody DetalleFacturaProveedorMongo detalle) {
        try {
            DetalleFacturaProveedorMongo nuevoDetalle = detalleService.save(detalle);
            return ResponseEntity.ok(nuevoDetalle);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/batch")
    public ResponseEntity<List<DetalleFacturaProveedorMongo>> createMultipleDetalles(@RequestBody List<DetalleFacturaProveedorMongo> detalles) {
        try {
            List<DetalleFacturaProveedorMongo> nuevosDetalles = detalleService.saveAll(detalles);
            return ResponseEntity.ok(nuevosDetalles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFacturaProveedorMongo> updateDetalle(@PathVariable String id, @RequestBody DetalleFacturaProveedorMongo detalle) {
        try {
            Optional<DetalleFacturaProveedorMongo> detalleExistente = detalleService.findById(id);
            if (detalleExistente.isPresent()) {
                detalle.setId(id);
                DetalleFacturaProveedorMongo detalleActualizado = detalleService.save(detalle);
                return ResponseEntity.ok(detalleActualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable String id) {
        try {
            Optional<DetalleFacturaProveedorMongo> detalle = detalleService.findById(id);
            if (detalle.isPresent()) {
                detalleService.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/factura/{facturaId}")
    public ResponseEntity<Void> deleteDetallesByFacturaId(@PathVariable String facturaId) {
        try {
            detalleService.deleteByFacturaId(facturaId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/total/factura/{facturaId}")
    public ResponseEntity<Double> getTotalByFacturaId(@PathVariable String facturaId) {
        try {
            Double total = detalleService.calcularTotalPorFactura(facturaId);
            return ResponseEntity.ok(total);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
