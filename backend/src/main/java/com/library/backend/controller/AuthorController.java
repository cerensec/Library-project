package com.library.backend.controller;

import com.library.backend.model.Author;
import com.library.backend.service.implementation.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    private AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("getAll")
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Author> getById(@PathVariable String id){
        return new ResponseEntity<>(authorService.getAuthorById(id),HttpStatus.FOUND);
    }
}
