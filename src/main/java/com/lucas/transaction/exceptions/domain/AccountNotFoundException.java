package com.lucas.transaction.exceptions.domain;

public class AccountNotFoundException extends DomainException {
    public AccountNotFoundException(){
        super("Account not found.");
    }
}
