package com.ilyas.api_bancaire.controller;

import com.ilyas.api_bancaire.dto.LoginRequest;
import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.service.RegisterService;
import org.springframework.web.bind.annotation.*;
import com.ilyas.api_bancaire.dto.RegisterRequest;

@RestController
@RequestMapping("/api/users")
public class RegisterController {

    private final RegisterService RegisterService;

    public RegisterController(RegisterService RegisterService) {
        this.RegisterService = RegisterService;
    }





    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){

        return RegisterService.register(request);

    }
}