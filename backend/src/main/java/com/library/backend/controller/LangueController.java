package com.library.backend.controller;

import com.library.backend.model.Langue;
import com.library.backend.service.implementation.LangueServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/language")
public class LangueController {

    private LangueServiceImpl langueService;

    public LangueController(LangueServiceImpl langueService) {
        this.langueService = langueService;
    }

    @GetMapping("getAll")
    public List<Langue> getAllLangues(){
        return langueService.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Langue> getLangueById(@PathVariable int id){
        return new ResponseEntity<>(langueService.getLangueById(id), HttpStatus.FOUND);
    }
}
