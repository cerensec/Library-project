package com.library.backend.controller;

import com.library.backend.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public boolean login(@RequestBody String username, @RequestBody String password){
        return accountService.login(username,password);
    }
}
