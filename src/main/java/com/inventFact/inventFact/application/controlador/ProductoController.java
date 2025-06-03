package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.application.service.ProductoService;
import com.inventFact.inventFact.domain.entity.Producto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/producto")
@CrossOrigin("http://localhost:4200")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> findAll() {

        List<Producto> productoList = productoService.findAll();

        if(productoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(productoList);
    }

    @GetMapping("/visible")
    public ResponseEntity<List<Producto>> findAllVisible(Long id){
        List<Producto> productoList = productoService.findAllVisible(id);
        if (productoList.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
        return ResponseEntity.ok(productoList);
    }

    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<Producto> findByNombre(@PathVariable String nombre){
        Producto producto1 = productoService.findByNombre(nombre);
        if (producto1 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(producto1);
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable Long id){
        return productoService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        producto.setFechaIngreso(new Date());
        Producto savedProducto = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto){

        if (!id.equals(producto.getIdProducto())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Producto producto1 = productoService.findById(id);

        if (producto1 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        producto1.setNombreProducto(producto.getNombreProducto());
        producto1.setDisponibilidad(producto.getDisponibilidad());
        producto1.setCantidadDisponoble(producto.getCantidadDisponoble());
        producto1.setVisible(producto.getVisible());
        return ResponseEntity.ok(productoService.save(producto1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (productoService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
