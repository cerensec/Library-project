package com.library.backend.controller;

import com.library.backend.model.BookItem;
import com.library.backend.service.implementation.AuthorServiceImpl;
import com.library.backend.service.implementation.CatalogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private CatalogServiceImpl catalogServiceImpl;

    public CatalogController(CatalogServiceImpl catalogServiceImpl) {
        this.catalogServiceImpl = catalogServiceImpl;
    }
    // Search
    @GetMapping("getAll")
    public List<BookItem> getAllBooks(){
        return catalogServiceImpl.getAllBooks();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<BookItem> getBookById(@PathVariable String id){
        return new ResponseEntity<>(catalogServiceImpl.getBookById(id),HttpStatus.FOUND);
    }

    @GetMapping("getByFilters/{filters}")
    public List<BookItem> getBooksWithFilter(@PathVariable String filters){
        return catalogServiceImpl.getBooksWithFilter(filters);
    }

    //Manage
    @PostMapping("saveBook")
    public ResponseEntity<BookItem> saveBook(@RequestBody BookItem bookItem){
        return new ResponseEntity<>(bookItem, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BookItem> updateBook(@RequestBody BookItem bookItem, @PathVariable String id){
        return new ResponseEntity<>(catalogServiceImpl.updateBook(bookItem,id),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id){
        catalogServiceImpl.deleteBook(id);
        return new ResponseEntity<>("Book deleted successfully !", HttpStatus.OK);
    }

}
