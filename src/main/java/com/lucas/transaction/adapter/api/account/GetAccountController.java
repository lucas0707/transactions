package com.lucas.transaction.adapter.api.account;

import com.lucas.transaction.adapter.DTO.account.AccountDetailsResponseDTO;
import com.lucas.transaction.service.account.GetAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetAccountController {
    private final GetAccountService accountService;

    @Autowired
    public GetAccountController(GetAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/{accountId}")
    public @ResponseBody
    AccountDetailsResponseDTO getAccountDetails(@PathVariable(value="accountId") Long accountId) throws Exception {
        return accountService.getAccount(accountId);
    }
}
