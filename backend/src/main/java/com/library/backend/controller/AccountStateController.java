package com.library.backend.controller;

import com.library.backend.model.AccountState;
import com.library.backend.service.implementation.AccountStateServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/accountStates")
public class AccountStateController {

    private AccountStateServiceImpl accountStateService;

    public AccountStateController(AccountStateServiceImpl accountStateService) {
        this.accountStateService = accountStateService;
    }

    @RequestMapping("getAll")
    public List<AccountState> getAll(){
        return accountStateService.getAllAccountStates();
    }

    @RequestMapping("getById/{id}")
    public ResponseEntity<AccountState> getAccountStateById(@PathVariable int id){
        return new ResponseEntity<>(accountStateService.getAccountStateById(id), HttpStatus.FOUND);
    }
}
