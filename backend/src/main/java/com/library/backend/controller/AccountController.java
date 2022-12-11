package com.library.backend.controller;

import com.library.backend.model.Account;
import com.library.backend.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("login")
    public boolean login(@RequestBody Account account){
        return accountService.login(account.getUsername(),account.getPassword());
    }
}
