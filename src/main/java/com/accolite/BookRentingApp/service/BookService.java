package com.accolite.BookRentingApp.service;


import com.accolite.BookRentingApp.model.Book;
import com.accolite.BookRentingApp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Method to find a book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Method to search books by genre
    public List<Book> findBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    // Method to search books by title (partial match)
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    // Method to find books by genre and title
    public List<Book> searchBooks(String genre, String title) {
        return bookRepository.findByGenreAndTitleContainingIgnoreCase(genre, title);
    }

    // Method to update a book
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    // Method to delete a book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

