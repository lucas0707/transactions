package com.lucas.transaction.unit.domain.entities;

import com.lucas.transaction.domain.entities.account.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountTests {

    @Test
    public void testGettersAndSetters() {
        var accountId = 1L;
        var documentNumber = "12345678900";
        var account = new Account(accountId, documentNumber);

        assertEquals(accountId, account.getAccountId());
        assertEquals(documentNumber, account.getDocumentNumber());
    }

    @Test
    public void testGetterAndSetterDocumentNumber() {
        var documentNumber = "12345678900";
        var account = new Account(documentNumber);

        assertEquals(documentNumber, account.getDocumentNumber());
    }
}
