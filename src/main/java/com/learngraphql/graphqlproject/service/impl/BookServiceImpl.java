package com.learngraphql.graphqlproject.service.impl;

import com.learngraphql.graphqlproject.entities.Book;
import com.learngraphql.graphqlproject.repositories.BookRepo;
import com.learngraphql.graphqlproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book create(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book get(int bookId) {
        return this.bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found on server"));
    }
}
