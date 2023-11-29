package org.crazyit.app.controller;

import org.crazyit.app.domain.Book;
import org.crazyit.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public Book create(@RequestBody Book book) {
        return this.bookService.createOrUpdate(book);
    }

    @PutMapping("")
    public Book update(@RequestBody Book book) {
        Objects.requireNonNull(book);
        return this.bookService.createOrUpdate(book);
    }

    @GetMapping("")
    public Collection<Book> list() {
        return this.bookService.list();
    }

}