package com.lucas.transaction.unit.service.account;

import com.lucas.transaction.domain.entities.account.Account;
import com.lucas.transaction.domain.ports.AccountRepository;
import com.lucas.transaction.exceptions.domain.AccountCreationFailedException;
import com.lucas.transaction.service.account.CreateAccountService;
import com.lucas.transaction.service.account.CreateAccountServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateAccountServiceTests {
    private CreateAccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    public void init() {
        this.accountService = new CreateAccountServiceImpl(accountRepository);
    }

    @Captor ArgumentCaptor<Account> captor;
    @Test
    public void createAccountSuccessTest() throws Exception {
        var document_number = "12345678900";

        accountService.create(document_number);

        verify(accountRepository, times(1)).createAccount(captor.capture());
        Assertions.assertEquals(document_number, captor.getValue().getDocumentNumber());
    }

    @Test
    public void createAccountFailedTest() throws Exception {
        var document_number = "12345678900";

        doThrow(new Exception()).when(accountRepository).createAccount(any(Account.class));

        var thrown = assertThrows(
                AccountCreationFailedException.class,
                () -> accountService.create(document_number),
                "Could not create account."
        );

        assertTrue(thrown.getMessage().contains("Could not create account."));
    }
}
