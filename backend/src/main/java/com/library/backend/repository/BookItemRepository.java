package com.library.backend.repository;


import com.library.backend.model.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookItemRepository extends JpaRepository<BookItem, String> {

    @Query("SELECT b FROM BookItem b WHERE b.title LIKE ?1 OR b.name LIKE ?1 OR b.author.name LIKE ?1 OR b.subject LIKE ?1 OR b.overview LIKE ?1 OR b.publisher LIKE ?1 OR b.tag LIKE ?1 OR b.format.name LIKE ?1 OR b.langue.name LIKE ?1")
    List<BookItem> getBookItemByFilter(String filter);
}
