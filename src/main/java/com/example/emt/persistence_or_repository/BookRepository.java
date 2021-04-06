package com.example.emt.persistence_or_repository;

import com.example.emt.model.Book;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
}
