package com.library.backend.controller;

import com.library.backend.model.Format;
import com.library.backend.service.implementation.FormatServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/format")
public class FormatController {

    private FormatServiceImpl formatService;

    public FormatController(FormatServiceImpl formatService) {
        this.formatService = formatService;
    }

    @GetMapping("getAll")
    public List<Format> getAllFormats(){
        return formatService.getAllFormats();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Format> getFormatById(@PathVariable int id){
        return new ResponseEntity<>(formatService.getFormatById(id), HttpStatus.FOUND);
    }
}
