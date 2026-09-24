package com.ilyas.api_bancaire.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "accounts")

public class accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountid")
    private Long accountId;
    @Column(name="account_number")
    private String account_number;
    @Column(name="iban")
    private String iban;
    @Column (name = "balance")
    private Integer balance ;
    @Column (name="account_type")
    private String account_type;
    @Column (name="account_status")
    private String account_status;
    @Column (name="created_at")
    private LocalDateTime created_at;
    @Column (name="user_id")
    private Long userId;


    public Long getaccountId() {
        return accountId;
    }

    public void setaccountId(Long account_id) {
        this.accountId = accountId;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
