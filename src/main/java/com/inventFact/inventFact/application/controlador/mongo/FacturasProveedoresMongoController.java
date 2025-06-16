package com.inventFact.inventFact.application.controlador.mongo;

import com.inventFact.inventFact.application.service.mongo.FacturasProveedoresMongoService;
import com.inventFact.inventFact.domain.mongo.entity.FacturasProveedoresMongo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mongo/facturas-proveedores")
public class FacturasProveedoresMongoController {
    private final FacturasProveedoresMongoService service;

    public FacturasProveedoresMongoController(FacturasProveedoresMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<FacturasProveedoresMongo> getAll() {
        return service.findAll();
    }

    @PostMapping
    public FacturasProveedoresMongo create(@RequestBody FacturasProveedoresMongo factura) {
        return service.save(factura);
    }

    // Otros endpoints si los necesitas
}
