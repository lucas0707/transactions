package com.lucas.transaction.service.account;

import com.lucas.transaction.adapter.DTO.account.AccountDetailsResponseDTO;
import com.lucas.transaction.exceptions.domain.AccountNotFoundException;

public interface GetAccountService {
    AccountDetailsResponseDTO getAccount(Long accountId) throws AccountNotFoundException;
}
