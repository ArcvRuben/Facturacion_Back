package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.application.service.CategoriaService;
import com.inventFact.inventFact.domain.entity.Categoria;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias = categoriaService.findAll();

        if (categorias.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        return  ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
        if (id.equals(categoria.getIdCategoria())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Categoria categoria1 = categoriaService.findById(id);
        if( categoria1 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        categoria1.setNombreCategoria(categoria.getNombreCategoria());

        categoriaService.save(categoria1);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(categoriaService.findById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
