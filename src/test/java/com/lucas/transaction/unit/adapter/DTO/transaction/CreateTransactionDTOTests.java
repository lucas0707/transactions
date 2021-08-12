package com.lucas.transaction.unit.adapter.DTO.transaction;

import com.lucas.transaction.adapter.DTO.transactions.CreateTransactionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CreateTransactionDTOTests {
    @Test
    public void testGettersAndSetters() {
        var accountId = 1L;
        var operationTypeId = 1;
        double amount = -50.0;
        var dto = new CreateTransactionDTO(accountId, operationTypeId, amount );

        assertEquals(accountId, dto.getAccount_id());
        assertEquals(operationTypeId, dto.getOperationTypeId());
        assertEquals(amount, dto.getAmount());
    }
}
