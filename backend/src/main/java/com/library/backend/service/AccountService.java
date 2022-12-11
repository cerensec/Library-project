package com.library.backend.service;

import com.library.backend.model.Account;

public interface AccountService {

    Account login(String username, String password);
}
