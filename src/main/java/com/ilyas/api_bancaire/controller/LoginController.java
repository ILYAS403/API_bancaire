package com.ilyas.api_bancaire.controller;

import com.ilyas.api_bancaire.dto.LoginRequest;
import com.ilyas.api_bancaire.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    private final LoginService LoginService;

    public LoginController(LoginService LoginService) {
        this.LoginService = LoginService;
    }




    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        String token = LoginService.login(  // appel a loginService
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity.ok(token);
    }

}
