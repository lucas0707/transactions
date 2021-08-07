package com.lucas.transaction.adapter.api.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAccountController {

    @RequestMapping("/")
    public @ResponseBody String getAccountDetails()
    {
        return "hello world";
    }
}
