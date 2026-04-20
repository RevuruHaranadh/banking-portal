package com.example.bankingportal.controller;

import com.example.bankingportal.dto.AuthResponse;
import com.example.bankingportal.dto.LoginRequest;
import com.example.bankingportal.dto.RegisterRequest;
import com.example.bankingportal.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}