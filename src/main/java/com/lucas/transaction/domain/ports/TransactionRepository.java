package com.lucas.transaction.domain.ports;

import com.lucas.transaction.domain.entities.transaction.Transaction;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);
}
