package com.ilyas.api_bancaire.controller;

import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.service.LoginUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginUserController {

    private final LoginUserService loginuserService;

    public LoginUserController(LoginUserService loginuserService) {
        this.loginuserService = loginuserService;
    }

    @GetMapping
    public User login(@RequestParam String email,
                      @RequestParam String password) {

        return loginuserService.getUserByLogin(email,password);
    }
}