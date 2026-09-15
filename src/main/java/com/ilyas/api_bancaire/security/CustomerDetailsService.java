package com.ilyas.api_bancaire.security;

import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Authentication Manager qui l a sollicite automatiquement
@Service
public class CustomerDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomerDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Utilisateur introuvable"));
    // user d espring securite
        // je construis
        return org.springframework.security.core.userdetails.User

                .withUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}