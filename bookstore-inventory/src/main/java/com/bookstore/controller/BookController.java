package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookstoreService bookstoreService;

    @Autowired
    public BookController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookstoreService.addBook(book);
    }
    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookstoreService.removeBook(id);
    }

    @PutMapping("/{id}/quantity")
    public Book updateQuantity(@PathVariable Long id, @RequestParam int quantity) {
        return bookstoreService.updateQuantity(id, quantity);
    }

    @GetMapping("/{id}/quantity")
    public int getQuantityInStock(@PathVariable Long id) {
        return bookstoreService.getQuantityInStock(id);
    }

    @GetMapping
    public List<Book> listAllBooks() {
        return bookstoreService.listAllBooks();
    }
}
