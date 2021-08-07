package com.lucas.transaction.adapter.api.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAccountController {

    @GetMapping("/account")
    public @ResponseBody String getAccountDetails()
    {
        return "hello world";
    }
}
