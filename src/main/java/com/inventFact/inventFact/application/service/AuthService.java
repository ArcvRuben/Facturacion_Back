package com.inventFact.inventFact.application.service;

import com.inventFact.inventFact.domain.entity.Auth;
import com.inventFact.inventFact.domain.entity.AuthResponse;
import com.inventFact.inventFact.domain.service.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public List<Auth> findAll(){
        return authRepository.findAll();
    }

    public Auth findById(Long id){
        return authRepository.findById(id);
    };

    public AuthResponse save(Auth auth){
        return authRepository.save(auth);
    };

    public AuthResponse update(Auth auth){
        return authRepository.update(auth);
    };

    public void delete(Long id){
        authRepository.delete(id);
    };

    public Optional<Auth> findbyUserName(String username){
        return authRepository.findbyUserName(username);
    };
}
