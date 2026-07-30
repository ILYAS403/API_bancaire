package com.ilyas.api_bancaire.service;

import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileUserService {

    private final UserRepository userRepository;

    public ProfileUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
    }
}