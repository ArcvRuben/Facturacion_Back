package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.domain.entity.AuthResponse;
import com.inventFact.inventFact.domain.entity.LoginRequest;
import com.inventFact.inventFact.infrastructure.adapter.AuthResponseJpaAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthResponseController {
    private final AuthResponseJpaAdapter authResponseJpaAdapter;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authResponseJpaAdapter.login(request));
    }

}
