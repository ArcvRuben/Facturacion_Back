package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.Jwt.JwtService;
import com.inventFact.inventFact.domain.entity.Auth;
import com.inventFact.inventFact.domain.entity.AuthResponse;
import com.inventFact.inventFact.domain.entity.Usuario;
import com.inventFact.inventFact.domain.service.AuthRepository;
import com.inventFact.inventFact.domain.service.UsuarioRepository;
import com.inventFact.inventFact.infrastructure.persistence.AuthJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class AuthJpaAdapter implements AuthRepository {

    private final AuthJpaRepository authJpaRepository;
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public List<Auth> findAll() {
        return authJpaRepository.findAll();
    }

    @Override
    public Auth findById(Long id) {
        return authJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontraron registros"));
    }

    @Override
    public AuthResponse save(Auth auth) {

        Usuario usuario = auth.getUsuario();
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        Auth authSave = Auth.builder()
                .username(auth.getUsername())
                .password(passwordEncoder.encode(auth.getPassword()))
                .usuario(usuarioGuardado)
                .build();
        authJpaRepository.save(authSave);

        return AuthResponse.builder()
                .token(jwtService.getToken(authSave))
                .build();
    }

    @Override
    public AuthResponse update(Auth auth) {
        // Buscar el registro existente
        Auth existingAuth = authJpaRepository.findById(auth.getId_auth()).orElseThrow(() ->
                new RuntimeException("No se encontró el usuario con ID: " + auth.getUsuario().getId()));

        existingAuth.setPassword(passwordEncoder.encode(auth.getPassword()));
        authJpaRepository.save(existingAuth);

        return AuthResponse.builder()
                .token(jwtService.getToken(existingAuth))
                .build();
    }

    @Override
    public void delete(Long id) {
        authJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Auth> findbyUserName(String username) {
        return authJpaRepository.findByUsername(username);
    }
}
