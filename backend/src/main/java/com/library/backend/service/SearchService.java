package com.library.backend.service;

import com.library.backend.model.BookItem;

import java.util.List;

public interface SearchService {

    List<BookItem> getAllBooks();

    BookItem getBookById(String id);

    List<BookItem> getBooksWithFilter(String filters);
}
