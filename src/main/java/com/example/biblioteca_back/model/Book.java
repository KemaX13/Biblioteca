package com.example.biblioteca_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private long isbn;
    private String description;
    private String genre;
    private String cover;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Loan> loans;

    public Book(String author, String title, String description, long isbn, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.genre = genre;
        this.cover = cover;
    }

    public Book(String title, String author, String description, String genre, String cover) {
    }
}
