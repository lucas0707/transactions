package com.lucas.transaction.adapter.repository.account;

import com.lucas.transaction.domain.entities.account.Account;
import com.lucas.transaction.domain.ports.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcAccountRepository implements AccountRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void createAccount(Account account) {
        jdbc.update("insert into Accounts(Document_Number) values(?)", account.getDocumentNumber());
    }

    @Override
    public Account getById(Long accountId) {
        return jdbc.queryForObject("select * from Accounts where Account_ID = ?",
                new Object[]{accountId},
                (rs, rowNum) -> new Account(
                        rs.getLong("Account_ID"),
                        rs.getString("Document_Number")
                ));
    }

    @Override
    public boolean accountExists(Long account_id) {
        var result =  jdbc.queryForObject(
                "select count(*) from Accounts where Account_ID = ?",
                Integer.class,
                account_id
        );

        return result != null && result != 0;
    }
}
