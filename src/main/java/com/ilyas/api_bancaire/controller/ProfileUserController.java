package com.ilyas.api_bancaire.controller;

import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.service.ProfileUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class ProfileUserController {

    private final ProfileUserService profileuserService;

    public ProfileUserController(ProfileUserService profileuserService) {
        this.profileuserService = profileuserService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return profileuserService.getUserById(id);
    }
}