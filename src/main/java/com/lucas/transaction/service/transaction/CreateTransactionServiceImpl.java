package com.lucas.transaction.service.transaction;

import com.lucas.transaction.adapter.DTO.transactions.CreateTransactionDTO;
import com.lucas.transaction.domain.ports.AccountRepository;
import com.lucas.transaction.domain.ports.OperationTypeRepository;
import com.lucas.transaction.domain.ports.TransactionRepository;
import com.lucas.transaction.domain.entities.transaction.Transaction;
import com.lucas.transaction.exceptions.domain.AccountNotFoundException;
import com.lucas.transaction.exceptions.domain.DomainException;
import com.lucas.transaction.exceptions.domain.OperationTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionServiceImpl implements CreateTransactionService{
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final OperationTypeRepository operationRepository;

    @Autowired
    public CreateTransactionServiceImpl(
            TransactionRepository transactionRepository,
            AccountRepository accountRepository,
            OperationTypeRepository operationRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @Override
    public void create(CreateTransactionDTO transactionDTO) throws Exception {
        try {
            validateAccount(transactionDTO.getAccount_id());
            validateOperationType(transactionDTO.getOperationTypeId());

            var transaction = createTransaction(transactionDTO);
            transactionRepository.createTransaction(transaction);
        } catch (DomainException ex) {
            throw new Exception(ex);
        }
    }

    private void validateOperationType(int operationTypeId) throws Exception {
        if (!operationRepository.hasOperationType(operationTypeId)) {
            throw new OperationTypeNotFoundException();
        }
    }

    private void validateAccount(Long account_id) throws Exception {
       if (!accountRepository.accountExists(account_id)) {
           throw new AccountNotFoundException();
       }
    }

    private Transaction createTransaction(CreateTransactionDTO transactionDTO) {
        return new Transaction(
                transactionDTO.getAmount(),
                transactionDTO.getAccount_id(),
                transactionDTO.getOperationTypeId()
        );
    }
}
