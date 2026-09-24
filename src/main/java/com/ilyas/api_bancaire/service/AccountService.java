package com.ilyas.api_bancaire.service;

import com.ilyas.api_bancaire.entity.User;
import com.ilyas.api_bancaire.entity.accounts;
import com.ilyas.api_bancaire.repository.AccountRepository;
import com.ilyas.api_bancaire.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class AccountService {


    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;

        this.userRepository = userRepository;
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
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        accounts  account = new accounts();
        account.setAccount_number(gerereNumeroAccount());
        account.setIban(genereIBAN());
        account.setBalance(0);
        account.setAccount_type(account_type);
        account.setAccount_status("ACTIVE");
        account.setCreated_at(LocalDateTime.now());



        account.setUserId(user.getUserId());
        return accountRepository.save(account);
    }

    public Integer  getBalanceAccount() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        List<accounts> Myaccount = accountRepository.findAccountByuserId(user.getUserId());

        System.out.println("Bienvenu" + user.getFirstName());
        for (accounts account : Myaccount) {
        if (account.getAccount_type().equals("CHECKING")) {

            System.out.println("Le solde de votre compte courant est :");
            return account.getBalance();

        } else if (account.getAccount_type().equals("SAVINGS")) {

            System.out.println("Le solde de votre compte epargne est :");
            return account.getBalance();

        }}
        return 0;
    }

}
