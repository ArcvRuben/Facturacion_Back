package com.inventFact.inventFact.domain.service;

import com.inventFact.inventFact.domain.entity.FacturaCliente;

import java.util.List;

public interface FacturaClienteService {
    FacturaCliente save(FacturaCliente facturaCliente);
    List<FacturaCliente> findAll();
    FacturaCliente findById(Long id);
    void delete(Long id);
}

