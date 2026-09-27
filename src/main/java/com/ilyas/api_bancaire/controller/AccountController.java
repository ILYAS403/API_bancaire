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

    @PostMapping("/createAccount")
    public accounts createAccount(@RequestBody AccountRequest request) {

        return accountService.createAccount(request.getAccountType());
    }

    @GetMapping("/getSode")
    public Integer getBalanceAccount() {
        return accountService.getBalanceAccount();
    }


    @PostMapping("/depot")
    public void  deposit(@RequestBody Integer montants ) {
       accountService.depositService(montants);
    }

    @PostMapping("/retrait")
    public void retrait(@RequestBody Integer montants ) {
         accountService.retraitService(montants);
    }

    @PostMapping("/virrement")
    public void  virement(@RequestBody AccountRequest request ) {
         accountService.virementService(request.getAccountType(), request.getMontants());
    }
}
