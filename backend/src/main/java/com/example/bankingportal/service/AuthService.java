package com.example.bankingportal.service;

import com.example.bankingportal.dto.AuthResponse;
import com.example.bankingportal.dto.LoginRequest;
import com.example.bankingportal.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}