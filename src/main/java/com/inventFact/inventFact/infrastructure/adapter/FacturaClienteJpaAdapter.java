package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.domain.entity.FacturaCliente;
import com.inventFact.inventFact.domain.service.FacturaClienteService;
import com.inventFact.inventFact.infrastructure.persistence.FacturaClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FacturaClienteJpaAdapter implements FacturaClienteService {

    private final FacturaClienteRepository facturaClienteRepository;

    @Override
    public FacturaCliente save(FacturaCliente facturaCliente) {
        return facturaClienteRepository.save(facturaCliente);
    }

    @Override
    public List<FacturaCliente> findAll() {
        return facturaClienteRepository.findAll();
    }

    @Override
    public FacturaCliente findById(Long id) {
        return facturaClienteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        facturaClienteRepository.deleteById(id);
    }
}
