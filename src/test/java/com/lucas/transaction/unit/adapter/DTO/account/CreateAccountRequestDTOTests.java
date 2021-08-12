package com.lucas.transaction.unit.adapter.DTO.account;

import com.lucas.transaction.adapter.DTO.account.CreateAccountRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CreateAccountRequestDTOTests {

    @Test
    public void testGettersAndSetters() {
        var document_number = "12345678900";
        var dto = new CreateAccountRequestDTO(document_number);

        assertEquals(document_number, dto.getDocumentNumber());
    }
}
