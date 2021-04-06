package com.example.emt.web_or_presentation.controller;

import com.example.emt.model.Book;
import com.example.emt.service_or_business.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;

    }


    @GetMapping
    public String getBookPage(Model model) {
        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }



    @GetMapping("/add-new")
    public String addNewBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @GetMapping("/{id}/edit")
    public String editPage(Model model, @PathVariable Long id){
        try {
            Book book = this.bookService.findById(id);

            model.addAttribute("book",book);

            return "add-book";
        }catch (RuntimeException exception){
            return "redirect:/books?error=" + exception.getMessage();
        }
    }

    @PostMapping
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            List<Book> books = this.bookService.findAll();
            model.addAttribute("books", books);
            return "add-book";
        }

        this.bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id){
        this.bookService.deleteById(id);
        return "redirect:/books";
    }

}
