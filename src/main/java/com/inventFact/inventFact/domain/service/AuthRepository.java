package com.inventFact.inventFact.domain.service;

import com.inventFact.inventFact.domain.entity.Auth;
import com.inventFact.inventFact.domain.entity.AuthResponse;

import java.util.List;
import java.util.Optional;

public interface AuthRepository {
    public List<Auth> findAll();
    public Auth findById(Long id);
    public AuthResponse save(Auth auth);
    public AuthResponse update(Auth auth);
    public void delete(Long id);
    public Optional<Auth> findbyUserName(String username);
}
