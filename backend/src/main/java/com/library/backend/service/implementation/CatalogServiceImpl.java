package com.library.backend.service.implementation;

import com.library.backend.model.BookItem;
import com.library.backend.repository.AuthorRepository;
import com.library.backend.repository.BookItemRepository;
import com.library.backend.service.ManageService;
import com.library.backend.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements SearchService, ManageService {

    private BookItemRepository bookItemRepository;
    private AuthorRepository authorRepository;

    public CatalogServiceImpl(BookItemRepository bookItemRepository) {
        this.bookItemRepository = bookItemRepository;
    }

    // Search Service implementation
    @Override
    public List<BookItem> getAllBooks() {
        return bookItemRepository.findAll();
    }

   @Override
    public BookItem getBookById(String id) {
        return bookItemRepository.findById(id).orElseThrow();
    }

    @Override
    public List<BookItem> getBooksWithFilter(String filters) {
        return bookItemRepository.getBookItemByFilter(filters);
    }

    // Manage Service implementation
    @Override
    public BookItem createBook(BookItem bookItem) {
        return bookItemRepository.save(bookItem);
    }

    @Override
    public BookItem updateBook(BookItem bookItem, String id) {
        BookItem book = bookItemRepository.findById(id).orElseThrow();

        book.setSubject(bookItem.getSubject());
        book.setPublicationDate(bookItem.getPublicationDate());
        book.setOverview(bookItem.getOverview());
        book.setPublisher(bookItem.getPublisher());
        book.setBarcode(bookItem.getBarcode());
        book.setTag(bookItem.getTag());
        book.setTitle(bookItem.getTitle());
        book.setAuthor(bookItem.getAuthor());
        book.setReferenceOnly(bookItem.isReferenceOnly());
        book.setLangue(bookItem.getLangue());
        book.setNumberOfPages(bookItem.getNumberOfPages());
        book.setFormat(bookItem.getFormat());
        book.setBorrowed(bookItem.getBorrowed());
        book.setLoanPeriod(bookItem.getLoanPeriod());
        book.setDueDate(bookItem.getDueDate());
        book.setIsOverdue(bookItem.getIsOverdue());

        bookItemRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(String id) {
        BookItem book = bookItemRepository.findById(id).orElseThrow();

        bookItemRepository.deleteById(id);
    }
}

