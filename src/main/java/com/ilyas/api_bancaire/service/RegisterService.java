package com.ilyas.api_bancaire.service;

import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.repository.UserRepository;
import com.ilyas.api_bancaire.dto.RegisterRequest;
import com.ilyas.api_bancaire.security.SecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder, SecurityConfig securityConfig) {

        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public User register(RegisterRequest request) {

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setRoleId(request.getRoleId());
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);

    }
}