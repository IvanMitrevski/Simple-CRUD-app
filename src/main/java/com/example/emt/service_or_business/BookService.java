package com.example.emt.service_or_business;

import com.example.emt.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book saveBook(String name, Integer price, Integer quantity);
    Book saveBook(Book book);
    void deleteById(Long id);
}
