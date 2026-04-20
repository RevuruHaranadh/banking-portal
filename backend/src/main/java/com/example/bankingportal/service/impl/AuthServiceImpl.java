package com.example.bankingportal.service.impl;

import com.example.bankingportal.dto.AuthResponse;
import com.example.bankingportal.dto.LoginRequest;
import com.example.bankingportal.dto.RegisterRequest;
import com.example.bankingportal.entity.Role;
import com.example.bankingportal.entity.User;
import com.example.bankingportal.repository.UserRepository;
import com.example.bankingportal.service.AuthService;
import com.example.bankingportal.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public String register(RegisterRequest request) {
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build();

        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, user.getRole().name());
    }
}