package com.lucas.transaction.exceptions.domain;

public class AccountCreationFailedException extends DomainException {
    public AccountCreationFailedException() {
        super("Could not create account.");
    }
}
