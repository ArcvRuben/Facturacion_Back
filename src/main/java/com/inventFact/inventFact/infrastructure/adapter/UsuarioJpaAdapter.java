package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.domain.entity.Usuario;
import com.inventFact.inventFact.domain.service.UsuarioRepository;
import com.inventFact.inventFact.infrastructure.persistence.UsuarioJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioJpaAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioJpaRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se han encontrado registros"));
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioJpaRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioJpaRepository.deleteById(id);
    }
}
