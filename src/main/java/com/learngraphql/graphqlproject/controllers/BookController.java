package com.learngraphql.graphqlproject.controllers;

import com.learngraphql.graphqlproject.entities.Book;
import com.learngraphql.graphqlproject.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPages(book.getPages());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        return this.bookService.create(b);
    }

    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }
}

@Getter
@Setter
class BookInput {
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
