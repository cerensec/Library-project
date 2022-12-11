package com.library.backend.repository;

import com.library.backend.model.AccountState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStateRepository extends JpaRepository<AccountState, Integer> {
}
