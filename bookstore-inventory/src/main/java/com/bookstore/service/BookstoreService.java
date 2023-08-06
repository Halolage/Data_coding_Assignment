package com.bookstore.service;


import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class BookstoreService {
    private final BookRepository bookRepository;

    @Autowired
    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateQuantity(Long id, int quantity) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Book not found"));

        book.setQuantity(quantity);
        return bookRepository.save(book);
    }

    public int getQuantityInStock(Long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Book not found"));

        return book.getQuantity();
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}

