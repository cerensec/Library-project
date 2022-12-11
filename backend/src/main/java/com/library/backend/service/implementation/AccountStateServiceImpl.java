package com.library.backend.service.implementation;

import com.library.backend.model.AccountState;
import com.library.backend.repository.AccountStateRepository;
import com.library.backend.service.AccountStateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStateServiceImpl implements AccountStateService {

    private AccountStateRepository accountStateRepository;

    public AccountStateServiceImpl(AccountStateRepository accountStateRepository) {
        this.accountStateRepository = accountStateRepository;
    }

    @Override
    public List<AccountState> getAllAccountStates() {
        return null;
    }

    @Override
    public AccountState getAccountStateById(int id) {
        return null;
    }
}
