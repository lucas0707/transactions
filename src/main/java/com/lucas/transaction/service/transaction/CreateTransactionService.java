package com.lucas.transaction.service.transaction;

import com.lucas.transaction.adapter.DTO.transactions.CreateTransactionDTO;

public interface CreateTransactionService {
    void create(CreateTransactionDTO transactionDTO) throws Exception;
}
