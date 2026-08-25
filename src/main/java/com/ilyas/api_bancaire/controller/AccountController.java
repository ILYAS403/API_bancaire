package com.ilyas.api_bancaire.controller;


import com.ilyas.api_bancaire.dto.RegisterRequest;
import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.entity.accounts;
import com.ilyas.api_bancaire.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")

public class AccountController {
    public final   AccountService accountService;


    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @PostMapping("/{accountType}")
    public accounts createAccount(@PathVariable String accountType) {
        return accountService.createAccount(accountType);
    }
}
