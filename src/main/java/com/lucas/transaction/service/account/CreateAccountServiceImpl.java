package com.lucas.transaction.service.account;

import com.lucas.transaction.domain.ports.AccountRepository;
import com.lucas.transaction.domain.entities.account.Account;
import com.lucas.transaction.exceptions.domain.AccountCreationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountServiceImpl implements CreateAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public CreateAccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(String documentNumber) throws AccountCreationFailedException {
        try {
            var account = new Account(documentNumber);
            accountRepository.createAccount(account);
        } catch (Exception ex) {
            throw new AccountCreationFailedException();
        }

    }
}
