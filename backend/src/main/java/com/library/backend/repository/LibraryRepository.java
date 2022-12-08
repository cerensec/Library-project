package com.library.backend.repository;

import com.library.backend.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
