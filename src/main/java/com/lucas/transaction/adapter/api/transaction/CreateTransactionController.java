package com.lucas.transaction.adapter.api.transaction;

import com.lucas.transaction.adapter.DTO.transactions.CreateTransactionDTO;
import com.lucas.transaction.service.transaction.CreateTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateTransactionController {
    private final CreateTransactionService transactionService;

    @Autowired
    public CreateTransactionController(CreateTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(name = "/transactions", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody void createTransaction(@RequestBody CreateTransactionDTO createTransactionDTO) throws Exception {
        transactionService.create(createTransactionDTO);
    }
}
