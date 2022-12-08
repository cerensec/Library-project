package com.library.backend.repository;

import com.library.backend.model.Langue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LangueRepository extends JpaRepository<Langue, Integer> {
}
