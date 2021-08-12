package com.lucas.transaction.adapter.repository.transaction;

import com.lucas.transaction.domain.entities.transaction.Transaction;
import com.lucas.transaction.domain.ports.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JdbcTransactionRepository implements TransactionRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTransactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        jdbcTemplate.update("insert into Transactions(" +
                        "Amount, " +
                        "Event_Date, " +
                        "Account_ID, " +
                        "Operation_Type_ID) " +
                        "values(?,?,?,?)",
                transaction.getAmount(),
                new Date(),
                transaction.getAccountId(),
                transaction.getOperationTypeId()
                );
        return transaction;
    }
}
