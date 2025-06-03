package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.application.service.ProveedorService;
import com.inventFact.inventFact.domain.entity.Proveedor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proveedor")
@CrossOrigin("*")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping("/")
    public ResponseEntity<List<Proveedor>> findAll(){
        List<Proveedor> proveedors = proveedorService.findAll();

        if (proveedors.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(proveedors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> findById(@PathVariable Long id){
        return ResponseEntity.ok(proveedorService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor){
        return  ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(proveedorService.findById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        proveedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
