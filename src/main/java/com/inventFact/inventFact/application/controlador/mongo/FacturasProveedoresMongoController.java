package com.inventFact.inventFact.application.controlador.mongo;

import com.inventFact.inventFact.application.service.mongo.FacturasProveedoresMongoService;
import com.inventFact.inventFact.domain.mongo.entity.FacturasProveedoresMongo;
import com.inventFact.inventFact.domain.mongo.entity.DetalleFacturaProveedorMongo;
import com.inventFact.inventFact.domain.mongo.dto.FacturaProveedorConDetallesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/mongo/facturas-proveedores")
@CrossOrigin(origins = "*")
public class FacturasProveedoresMongoController {
    
    private final FacturasProveedoresMongoService service;

    public FacturasProveedoresMongoController(FacturasProveedoresMongoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FacturasProveedoresMongo>> getAll() {
        List<FacturasProveedoresMongo> facturas = service.findAll();
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturasProveedoresMongo> getById(@PathVariable String id) {
        Optional<FacturasProveedoresMongo> factura = service.findById(id);
        return factura.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/proveedor/{proveedorId}")
    public ResponseEntity<List<FacturasProveedoresMongo>> getByProveedorId(@PathVariable String proveedorId) {
        List<FacturasProveedoresMongo> facturas = service.findByProveedorId(proveedorId);
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<FacturasProveedoresMongo>> getByEstadoPago(@PathVariable String estado) {
        List<FacturasProveedoresMongo> facturas = service.findByEstadoDePago(estado);
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/visible/{visible}")
    public ResponseEntity<List<FacturasProveedoresMongo>> getByVisible(@PathVariable Boolean visible) {
        List<FacturasProveedoresMongo> facturas = service.findByVisible(visible);
        return ResponseEntity.ok(facturas);
    }

    @PostMapping
    public ResponseEntity<FacturasProveedoresMongo> create(@RequestBody FacturasProveedoresMongo factura) {
        try {
            FacturasProveedoresMongo nuevaFactura = service.save(factura);
            return ResponseEntity.ok(nuevaFactura);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }    @PostMapping("/con-detalles")
    public ResponseEntity<FacturasProveedoresMongo> createWithDetalles(@RequestBody FacturaProveedorConDetallesDTO dto) {
        try {
            FacturasProveedoresMongo nuevaFactura = service.saveWithDetalles(dto.getFactura(), dto.getDetalles());
            return ResponseEntity.ok(nuevaFactura);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturasProveedoresMongo> update(@PathVariable String id, @RequestBody FacturasProveedoresMongo factura) {
        try {
            Optional<FacturasProveedoresMongo> facturaExistente = service.findById(id);
            if (facturaExistente.isPresent()) {
                factura.setId(id);
                FacturasProveedoresMongo facturaActualizada = service.save(factura);
                return ResponseEntity.ok(facturaActualizada);
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
            Optional<FacturasProveedoresMongo> factura = service.findById(id);
            if (factura.isPresent()) {
                service.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/estado-pago")
    public ResponseEntity<Void> updateEstadoPago(@PathVariable String id, @RequestBody Map<String, String> request) {
        try {
            String nuevoEstado = request.get("estadoDePago");
            service.updateEstadoPago(id, nuevoEstado);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/marcar-productos-registrados")
    public ResponseEntity<Void> marcarProductosRegistrados(@PathVariable String id) {
        try {
            service.marcarProductosRegistrados(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}/detalles")
    public ResponseEntity<List<DetalleFacturaProveedorMongo>> getDetallesByFacturaId(@PathVariable String id) {
        try {
            List<DetalleFacturaProveedorMongo> detalles = service.getDetallesByFacturaId(id);
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {            return ResponseEntity.badRequest().build();
        }
    }
}
