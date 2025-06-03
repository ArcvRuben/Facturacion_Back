package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.application.service.AuthService;
import com.inventFact.inventFact.domain.entity.Auth;
import com.inventFact.inventFact.domain.entity.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/")
    public List<Auth> index(){
        return authService.findAll();
    }

    @GetMapping("/{id}")
    public Auth show(@PathVariable Long id) {
        return authService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<AuthResponse> create(@RequestBody Auth auth) {
        return ResponseEntity.ok(authService.save(auth));
    }

    @PutMapping("/authUserName/{idAuth}")
    public ResponseEntity<AuthResponse> updateUsername(@PathVariable Long idAuth, @RequestBody Auth authRequest) {
        Auth auxAuth = authService.findById(idAuth);
        auxAuth.setUsername(authRequest.getUsername());
        return ResponseEntity.ok(authService.update(auxAuth));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authService.delete(id);
    }
}
