package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.application.service.FacturaClienteAppService;
import com.inventFact.inventFact.domain.entity.FacturaCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturaCliente")
@RequiredArgsConstructor
public class FacturaClienteController {

    private final FacturaClienteAppService facturaService;

    @PostMapping("/")
    public ResponseEntity<FacturaCliente> crearFactura(@RequestBody FacturaCliente factura) {
        return ResponseEntity.ok(facturaService.crearFactura(factura));
    }

    @GetMapping("/")
    public ResponseEntity<List<FacturaCliente>> obtenerFacturas() {
        return ResponseEntity.ok(facturaService.findAll());
    }
}

