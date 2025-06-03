package com.inventFact.inventFact.domain.service;

import com.inventFact.inventFact.domain.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {
    public List<Usuario> findAll();

    public Usuario findById(Long id);

    public Usuario save(Usuario usuario);

    public void delete(Long id);

}
