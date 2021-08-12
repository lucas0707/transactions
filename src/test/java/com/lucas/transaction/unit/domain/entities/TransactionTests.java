package com.lucas.transaction.unit.domain.entities;

import com.lucas.transaction.domain.entities.transaction.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class TransactionTests {

    @Test
    public void testGettersAndSetters() {
        var accountId = 1L;
        var operationTypeId = 1;
        var amount = 50.0;
        var transaction = new Transaction(amount, accountId, operationTypeId);


        assertEquals(accountId, transaction.getAccountId());
        assertEquals(operationTypeId, transaction.getOperationTypeId());
        assertEquals(amount, transaction.getAmount());
        assertNotEquals(null, transaction.getEventDate());
    }

    @Test
    public void testGettersAndSettersWithIdAndDate() {
        var transactionId = 1L;
        var accountId = 1L;
        var operationTypeId = 1;
        var amount = 50.0;
        var eventDate = new Date();
        var transaction = new Transaction(transactionId, amount, accountId, operationTypeId, eventDate);

        assertEquals(transactionId, transaction.getTransactionId());
        assertEquals(accountId, transaction.getAccountId());
        assertEquals(operationTypeId, transaction.getOperationTypeId());
        assertEquals(amount, transaction.getAmount());
        assertEquals(eventDate, transaction.getEventDate());
    }
}
