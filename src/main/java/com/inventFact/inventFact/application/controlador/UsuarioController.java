package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.domain.entity.Usuario;
import com.inventFact.inventFact.domain.service.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario findById(@PathVariable Long id){
        return usuarioRepository.findById(id);
    }

    @PostMapping("/usuario")
    public Usuario save(@RequestBody Usuario user){
        return  usuarioRepository.save(user);
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable Long id){
        usuarioRepository.delete(id);
    }
}
