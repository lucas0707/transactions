package com.lucas.transaction.adapter.api.account;

import com.lucas.transaction.adapter.DTO.account.CreateAccountRequestDTO;
import com.lucas.transaction.service.account.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateAccountController {
    private final CreateAccountService createAccountService;

    @Autowired
    public CreateAccountController(CreateAccountService createAccountService)
    {
        this.createAccountService = createAccountService;
    }

    @PostMapping(value = "/account", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    void createAccount(@RequestBody CreateAccountRequestDTO createAccountRequestDTO) throws Exception {
        var documentNumber = createAccountRequestDTO.getDocumentNumber();
        createAccountService.create(documentNumber);
    }
}
