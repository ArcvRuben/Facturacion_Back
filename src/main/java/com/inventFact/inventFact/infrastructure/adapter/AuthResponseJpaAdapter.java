package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.Jwt.JwtService;
import com.inventFact.inventFact.domain.entity.AuthResponse;
import com.inventFact.inventFact.domain.entity.LoginRequest;
import com.inventFact.inventFact.domain.service.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthResponseJpaAdapter {

    private final AuthRepository authRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        UserDetails user = authRepository.findbyUserName(loginRequest.getUsername()).orElseThrow();
        String token =jwtService.getToken(user);
        AuthResponse aut = new AuthResponse(token);
        return  aut;
    }
}
