package com.lucas.transaction.unit.service.account;

import com.lucas.transaction.domain.entities.account.Account;
import com.lucas.transaction.domain.ports.AccountRepository;
import com.lucas.transaction.exceptions.domain.AccountNotFoundException;
import com.lucas.transaction.service.account.GetAccountService;
import com.lucas.transaction.service.account.GetAccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetAccountServiceTests {
    private GetAccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    public void init() {
        this.accountService = new GetAccountServiceImpl(accountRepository);
    }

    @Captor
    ArgumentCaptor<Long> captor;
    @Test
    public void getAccountSuccessTest() throws Exception {
        long accountId = 1L;
        var document_number = "12345678900";
        when(accountRepository.getById(anyLong())).thenReturn(new Account(accountId, document_number));
        var account = accountService.getAccount(accountId);

        verify(accountRepository, times(1)).getById(captor.capture());
        Assertions.assertEquals(accountId, captor.getValue().longValue());
        assertEquals((long) account.getAccount_id(), accountId);
        assertEquals(account.getDocument_number(), document_number);
    }

    @Test
    public void getAccountFailedTest() throws Exception {
        var accountId = 1L;

        doThrow(new Exception()).when(accountRepository).getById(anyLong());

        var thrown = assertThrows(
                AccountNotFoundException.class,
                () -> accountService.getAccount(accountId),
                "Account not found."
        );

        assertTrue(thrown.getMessage().contains("Account not found."));
    }
}
