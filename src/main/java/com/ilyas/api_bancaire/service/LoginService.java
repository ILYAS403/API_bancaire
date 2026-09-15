package com.ilyas.api_bancaire.service;

import com.ilyas.api_bancaire.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;;
    public LoginService(AuthenticationManager authenticationManager, JwtService jwtService) {


        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String login(String email, String password) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                email,
                                password
                        )
                );
     // retourne du type generic mais je dis que c est du type UserDetails
        // UserDetails est un interface qui contient   qui represente les info de l utilisateur comme le nom, le mot de passe ou le role
        UserDetails user = (UserDetails) authentication.getPrincipal();

        return jwtService.generateToken(user);
    }

}
