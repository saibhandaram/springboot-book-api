package com.example.bookapi.service;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBookById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return repo.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setYear(book.getYear());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
