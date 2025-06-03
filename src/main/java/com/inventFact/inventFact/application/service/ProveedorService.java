package com.inventFact.inventFact.application.service;

import com.inventFact.inventFact.domain.entity.Categoria;
import com.inventFact.inventFact.domain.entity.Proveedor;
import com.inventFact.inventFact.domain.service.ProveedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll(){
        return proveedorRepository.findAll();
    }

    public Proveedor findById(Long id){
        return proveedorRepository.findById(id);
    }

    public Proveedor save(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public void delete(Long id){
        proveedorRepository.delete(id);
    }
}
