package com.inventFact.inventFact.application.service;

import com.inventFact.inventFact.domain.entity.FacturasProveedores;
import com.inventFact.inventFact.domain.entity.Proveedor;
import com.inventFact.inventFact.domain.service.FacturasProveedoresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FacturasProveedoresService {

    private final FacturasProveedoresRepository facturasProveedoresRepository;

    public List<FacturasProveedores> findAll(){
        return facturasProveedoresRepository.findAllVisible();
    }

    public FacturasProveedores findById(Long id){
        return facturasProveedoresRepository.findById(id);
    }

    public FacturasProveedores save(FacturasProveedores facturasProveedores){
        return facturasProveedoresRepository.save(facturasProveedores);
    }

    public void eliminarFactura(Long id){
        FacturasProveedores facturasProveedores = facturasProveedoresRepository.findById(id);
        facturasProveedores.setVisible(false);
        facturasProveedoresRepository.save(facturasProveedores);
    }
}
