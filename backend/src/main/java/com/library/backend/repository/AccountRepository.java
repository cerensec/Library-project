package com.library.backend.repository;

import com.library.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.username = ?1")
    Account getAccountByUsername(String username);
}
