package com.lucas.transaction.domain.ports;

import com.lucas.transaction.domain.entities.account.Account;

public interface AccountRepository {
    void createAccount(Account account);
    Account getById(Long accountId);
    boolean accountExists(Long account_id);
}
