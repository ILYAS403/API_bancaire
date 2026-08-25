package com.ilyas.api_bancaire.controller;

import com.ilyas.api_bancaire.dto.LoginRequest;
import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.service.ProfileUserService;
import org.springframework.web.bind.annotation.*;
import com.ilyas.api_bancaire.dto.RegisterRequest;

@RestController
@RequestMapping("/api/users")
public class ProfileUserController {

    private final ProfileUserService profileuserService;

    public ProfileUserController(ProfileUserService profileuserService) {
        this.profileuserService = profileuserService;
    }

    @GetMapping("login/{id}")
    public User getUserById(@PathVariable Long id) {

        return profileuserService.getUserById(id);
    }
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {

        return profileuserService.getUserByLogin(
                request.getEmail(),
                request.getPassword()
        );
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){

        return profileuserService.register(request);

    }
}