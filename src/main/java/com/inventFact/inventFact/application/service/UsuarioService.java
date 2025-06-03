package com.inventFact.inventFact.application.service;

import com.inventFact.inventFact.domain.entity.Usuario;
import com.inventFact.inventFact.domain.service.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    };

    public Usuario findById(Long id){
        return usuarioRepository.findById(id);
    };

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    };

    public void delete(Long id){
        usuarioRepository.delete(id);
    };
}
