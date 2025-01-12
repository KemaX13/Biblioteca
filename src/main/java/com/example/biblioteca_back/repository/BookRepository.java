package com.example.biblioteca_back.repository;

import com.example.biblioteca_back.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitleIgnoreCase(String title);

    List<Book> findByGenreContainingIgnoreCase(String genre);

    List<Book> findByAuthorContainingIgnoreCase(String author);

}
