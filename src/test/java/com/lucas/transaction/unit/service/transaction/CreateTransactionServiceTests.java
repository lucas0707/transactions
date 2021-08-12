package com.lucas.transaction.unit.service.transaction;

import com.lucas.transaction.adapter.DTO.transactions.CreateTransactionDTO;
import com.lucas.transaction.domain.entities.transaction.Transaction;
import com.lucas.transaction.domain.ports.AccountRepository;
import com.lucas.transaction.domain.ports.OperationTypeRepository;
import com.lucas.transaction.domain.ports.TransactionRepository;
import com.lucas.transaction.service.transaction.CreateTransactionService;
import com.lucas.transaction.service.transaction.CreateTransactionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateTransactionServiceTests {
    private CreateTransactionService createTransactionService;

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private OperationTypeRepository operationTypeRepository;

    @BeforeEach
    public void init() {
        this.createTransactionService = new CreateTransactionServiceImpl(
                transactionRepository,
                accountRepository,
                operationTypeRepository
        );
    }

    @Captor
    ArgumentCaptor<Transaction> captor;
    @Test
    public void createTransactionSuccessTest() throws Exception {
        long accountId = 1L;
        double amount = 10;
        int operationTypeId = 1;
        var dto = new CreateTransactionDTO(accountId, operationTypeId, amount);

        when(accountRepository.accountExists(anyLong())).thenReturn(true);
        when(operationTypeRepository.hasOperationType(anyInt())).thenReturn(true);

        createTransactionService.create(dto);

        verify(transactionRepository, times(1)).createTransaction(captor.capture());
        Assertions.assertEquals(accountId, captor.getValue().getAccountId());
        Assertions.assertEquals(operationTypeId, captor.getValue().getOperationTypeId());
        Assertions.assertEquals(amount, captor.getValue().getAmount());
    }

    @Test
    public void createTransactionFailedNoAccountFoundTest() throws Exception {
        long accountId = 1L;
        double amount = 10;
        int operationTypeId = 1;
        var dto = new CreateTransactionDTO(accountId, operationTypeId, amount);

        when(accountRepository.accountExists(anyLong())).thenReturn(false);

        var thrown = assertThrows(
                Exception.class,
                () -> createTransactionService.create(dto),
                "Account not found."
        );

        assertTrue(thrown.getMessage().contains("Account not found."));
    }

    @Test
    public void createTransactionFailedNoAccountFoundExceptionTest() throws Exception {
        long accountId = 1L;
        double amount = 10;
        int operationTypeId = 1;
        var dto = new CreateTransactionDTO(accountId, operationTypeId, amount);

        doThrow(new Exception("DatabaseException")).when(accountRepository).accountExists(anyLong());

        var thrown = assertThrows(
                Exception.class,
                () -> createTransactionService.create(dto),
                "DatabaseException."
        );

        assertTrue(thrown.getMessage().contains("DatabaseException"));
    }

    @Test
    public void createTransactionFailedNoOperationTypeFoundTest() throws Exception {
        long accountId = 1L;
        double amount = 10;
        int operationTypeId = 1;
        var dto = new CreateTransactionDTO(accountId, operationTypeId, amount);

        when(accountRepository.accountExists(anyLong())).thenReturn(true);
        when(operationTypeRepository.hasOperationType(anyInt())).thenReturn(false);

        var thrown = assertThrows(
                Exception.class,
                () -> createTransactionService.create(dto),
                "Operation Type not found."
        );

        assertTrue(thrown.getMessage().contains("Operation Type not found."));
    }

    @Test
    public void createTransactionFailedNoOperationTypeFoundExceptionTest() throws Exception {
        long accountId = 1L;
        double amount = 10;
        int operationTypeId = 1;
        var dto = new CreateTransactionDTO(accountId, operationTypeId, amount);

        when(accountRepository.accountExists(anyLong())).thenReturn(true);
        doThrow(new Exception("DatabaseException")).when(operationTypeRepository).hasOperationType(anyInt());

        var thrown = assertThrows(
                Exception.class,
                () -> createTransactionService.create(dto),
                "DatabaseException."
        );

        assertTrue(thrown.getMessage().contains("DatabaseException"));
    }

    @Test
    public void createTransactionFailedRepositoryExceptionTest() throws Exception {
        long accountId = 1L;
        double amount = 10;
        int operationTypeId = 1;
        var dto = new CreateTransactionDTO(accountId, operationTypeId, amount);

        when(accountRepository.accountExists(anyLong())).thenReturn(true);
        when(operationTypeRepository.hasOperationType(anyInt())).thenReturn(true);
        doThrow(new Exception("DatabaseException")).when(transactionRepository).createTransaction(any(Transaction.class));

        var thrown = assertThrows(
                Exception.class,
                () -> createTransactionService.create(dto),
                "DatabaseException."
        );

        assertTrue(thrown.getMessage().contains("DatabaseException"));
    }
}
