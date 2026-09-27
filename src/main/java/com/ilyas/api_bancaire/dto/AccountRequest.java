package com.ilyas.api_bancaire.dto;

public class AccountRequest {

    private String accountType;
    private Integer montants;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getMontants() {
        return montants;
    }

    public void setMontants(Integer montants) {
        this.montants = montants;
    }
}
