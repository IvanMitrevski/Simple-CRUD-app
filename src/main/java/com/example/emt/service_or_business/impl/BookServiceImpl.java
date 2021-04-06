package com.example.emt.service_or_business.impl;

import com.example.emt.model.Book;
import com.example.emt.model.exception.BookNotFoundException;
import com.example.emt.persistence_or_repository.BookRepository;
import com.example.emt.service_or_business.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book saveBook(String name, Integer price, Integer quantity) {

        Book book = new Book(null, name, price, quantity);
        return this.bookRepository.save(book);
    }

    @Override
    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
