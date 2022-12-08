package com.library.backend.service;

import com.library.backend.model.BookItem;

public interface ManageService {

    BookItem createBook(BookItem bookItem);

    BookItem updateBook(BookItem bookItem, String id);

    void deleteBook(String id);
}
