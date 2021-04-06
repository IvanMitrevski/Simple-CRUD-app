package com.example.emt.persistence_or_repository.impl;

import com.example.emt.model.Book;
import com.example.emt.persistence_or_repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private HashMap<Long, Book> books;
    private Long counter;

    @PostConstruct
    public void init() {
        this.counter = 0L;
        this.books = new HashMap<>();
        Long id = this.generateKey();

    }


    @Override
    public List<Book> findAll() {
        return new ArrayList<>(this.books.values());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(this.books.get(id));
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null){
            book.setId(this.generateKey());
        }
        this.books.put(book.getId(), book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        this.books.remove(id);
    }

    private Long generateKey() {
        return ++counter;
    }
}
