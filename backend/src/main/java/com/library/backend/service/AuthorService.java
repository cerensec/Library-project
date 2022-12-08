package com.library.backend.service;

import com.library.backend.model.Author;

import java.util.List;

public interface AuthorService {

    Author getAuthorById(String id);
    List<Author> getAll();
}
