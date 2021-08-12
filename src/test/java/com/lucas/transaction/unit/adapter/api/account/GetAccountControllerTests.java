package com.lucas.transaction.unit.adapter.api.account;

import com.lucas.transaction.adapter.DTO.account.AccountDetailsResponseDTO;
import com.lucas.transaction.adapter.api.account.GetAccountController;
import com.lucas.transaction.service.account.GetAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetAccountControllerTests {
    private GetAccountController getAccountController;

    @Mock
    private GetAccountService getAccountService;

    @BeforeEach
    public void init() {
        this.getAccountController = new GetAccountController(getAccountService);
    }

    @Captor
    ArgumentCaptor<Long> captor;
    @Test
    public void test() throws Exception
    {
        var accountId = 1L;
        var document_number = "12345678900";
        when(getAccountService.getAccount(anyLong())).thenReturn(new AccountDetailsResponseDTO(accountId, document_number));

        var response = getAccountController.getAccountDetails(accountId);

        verify(getAccountService, times(1)).getAccount(captor.capture());
        assertEquals(captor.getValue(), accountId);
        assertEquals(accountId, response.getAccount_id());
        assertEquals(document_number, response.getDocument_number());
    }
}
