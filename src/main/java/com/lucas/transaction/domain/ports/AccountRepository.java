package com.lucas.transaction.domain.ports;

import com.lucas.transaction.domain.entities.account.Account;

public interface AccountRepository {
    void createAccount(Account account) throws Exception;
    Account getById(Long accountId) throws Exception;
    boolean accountExists(Long account_id) throws Exception;
}
