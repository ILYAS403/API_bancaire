package com.ilyas.api_bancaire.controller;


import com.ilyas.api_bancaire.entity.accounts;
import com.ilyas.api_bancaire.service.AccountService;
import org.springframework.web.bind.annotation.*;
import com.ilyas.api_bancaire.dto.AccountRequest;

@RestController
@RequestMapping("/api/account")

public class AccountController {
    public final   AccountService accountService;


    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @PostMapping("/{createAccount}")
    public accounts createAccount(@RequestBody AccountRequest request) {

        return accountService.createAccount(request.getAccountType());
    }

    @GetMapping("/{getAccounts}")
    public Integer getBalanceAccount() {
        return accountService.getBalanceAccount();
    }
}
