package com.ilyas.api_bancaire.service;

import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.repository.UserRepository;
import com.ilyas.api_bancaire.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ProfileUserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public  User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
    }

    public User getUserByLogin(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
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