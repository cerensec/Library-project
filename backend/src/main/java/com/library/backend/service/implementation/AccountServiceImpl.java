package com.library.backend.service.implementation;

import com.library.backend.model.Account;
import com.library.backend.repository.AccountRepository;
import com.library.backend.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account login(String username, String password) {
        Account a = accountRepository.getAccountByUsername(username);
        if(a != null){
            if(password.equals(a.getPassword())){
                return a;
            }
        }
        return null;
    }


}
