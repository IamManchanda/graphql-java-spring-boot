package com.learngraphql.graphqlproject.repositories;

import com.learngraphql.graphqlproject.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
