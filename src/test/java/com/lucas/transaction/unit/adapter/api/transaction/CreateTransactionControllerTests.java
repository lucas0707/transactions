package com.lucas.transaction.unit.adapter.api.transaction;

import com.lucas.transaction.adapter.DTO.account.CreateAccountRequestDTO;
import com.lucas.transaction.adapter.DTO.transactions.CreateTransactionDTO;
import com.lucas.transaction.adapter.api.transaction.CreateTransactionController;
import com.lucas.transaction.service.transaction.CreateTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateTransactionControllerTests {
    private CreateTransactionController createTransactionController;

    @Mock
    private CreateTransactionService createTransactionService;

    @BeforeEach
    public void init() {
        this.createTransactionController = new CreateTransactionController(createTransactionService);
    }

    @Captor
    ArgumentCaptor<CreateTransactionDTO> captor;
    @Test
    public void test() throws Exception
    {
        var accountId = 1L;
        var amount = 50.0;
        var operationType = 1;

        var dto = new CreateTransactionDTO(accountId, operationType, amount);
        createTransactionController.createTransaction(dto);

        verify(createTransactionService, times(1)).create(captor.capture());
        assertEquals(captor.getValue().getAccount_id(), accountId);
        assertEquals(captor.getValue().getAmount(), amount);
        assertEquals(captor.getValue().getOperationTypeId(), operationType);
    }
}
