package com.lucas.transaction.unit.adapter.api.account;

import com.lucas.transaction.adapter.DTO.account.CreateAccountRequestDTO;
import com.lucas.transaction.adapter.api.account.CreateAccountController;
import com.lucas.transaction.service.account.CreateAccountService;
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
public class CreateAccountControllerTests {
    private CreateAccountController createAccountController;

    @Mock
    private CreateAccountService createAccountService;

    @BeforeEach
    public void init() {
        this.createAccountController = new CreateAccountController(createAccountService);
    }

    @Captor
    ArgumentCaptor<String> captor;
    @Test
    public void test() throws Exception
    {
        var document_number = "12345678900";

        var dto = new CreateAccountRequestDTO(document_number);
        createAccountController.createAccount(dto);

        verify(createAccountService, times(1)).create(captor.capture());
        assertEquals(captor.getValue(), document_number);
    }
}
