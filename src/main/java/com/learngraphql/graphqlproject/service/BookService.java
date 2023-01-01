package com.learngraphql.graphqlproject.service;

import com.learngraphql.graphqlproject.entities.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    List<Book> getAll();

    Book get(int bookId);
}
