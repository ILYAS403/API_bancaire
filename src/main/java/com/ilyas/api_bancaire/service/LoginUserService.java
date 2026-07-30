package com.ilyas.api_bancaire.service;


import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {

    private final UserRepository userRepository;

    public LoginUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String email, String password) {

        User user = userRepository.findByEmailAndPassword(email,password);

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
}
