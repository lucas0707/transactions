package com.lucas.transaction.unit.adapter.DTO.account;

import com.lucas.transaction.adapter.DTO.account.AccountDetailsResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountDetailResponseDTOTests {

    @Test
    public void testGettersAndSetters() {
        var accountId = 1L;
        var document_number = "12345678900";
        var dto = new AccountDetailsResponseDTO(accountId, document_number);

        assertEquals(accountId, dto.getAccount_id());
        assertEquals(document_number, dto.getDocument_number());
    }
}
