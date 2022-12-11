package com.library.backend.service;

import com.library.backend.model.AccountState;

import java.util.List;

public interface AccountStateService {

    List<AccountState> getAllAccountStates();
    AccountState getAccountStateById(int id);
}
