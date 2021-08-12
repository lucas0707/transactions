package com.lucas.transaction.service.account;

import com.lucas.transaction.adapter.DTO.account.AccountDetailsResponseDTO;
import com.lucas.transaction.domain.entities.account.Account;
import com.lucas.transaction.domain.ports.AccountRepository;
import com.lucas.transaction.exceptions.domain.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAccountServiceImpl implements GetAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public GetAccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDetailsResponseDTO getAccount(Long accountId) throws AccountNotFoundException {
        try {
            var account = accountRepository.getById(accountId);
            return createAccountDetailResponse(account);
        } catch(Exception ex) {
            throw new AccountNotFoundException();
        }
    }

    private AccountDetailsResponseDTO createAccountDetailResponse(Account account) {
        return new AccountDetailsResponseDTO(account.getAccountId(), account.getDocumentNumber());
    }
}
