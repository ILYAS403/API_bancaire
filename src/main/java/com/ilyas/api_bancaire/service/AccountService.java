package com.ilyas.api_bancaire.service;

import com.ilyas.api_bancaire.entity.accounts;
import com.ilyas.api_bancaire.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {


    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

    }

    public String gerereNumeroAccount(){
        Long LastIdaccount = accountRepository.findTopByOrderByAccountIdDesc().getaccountId();
        Long LastNumber=LastIdaccount + 1;
        return ("ACC10000" + LastNumber);
    }
    public String genereIBAN(){
       return ("FR76" + gerereNumeroAccount() );
    }

    public accounts createAccount(String account_type){
        accounts  account = new accounts();
        account.setAccount_number(gerereNumeroAccount());
        account.setIban(genereIBAN());
        account.setBalance(0);
        account.setAccount_type( account_type);
        account.setAccount_status("Active");
        account.setCreated_at(LocalDateTime.now());
        account.setUser_id(2L);
        return accountRepository.save(account);
    }

}
