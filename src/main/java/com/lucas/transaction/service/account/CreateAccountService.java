package com.lucas.transaction.service.account;


import com.lucas.transaction.exceptions.domain.AccountCreationFailedException;

public interface CreateAccountService {
    void create(String documentNumber) throws AccountCreationFailedException;
}
