package com.library.backend.service.implementation;

import com.library.backend.model.Author;
import com.library.backend.repository.AuthorRepository;
import com.library.backend.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getAuthorById(String id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
