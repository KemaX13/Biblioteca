package com.example.biblioteca_back.dto;

import com.example.biblioteca_back.model.Book;

public class BookMapper {

    public static Book dtoEntity(BookDTO bookDTO) {
        return new Book(bookDTO.title(), bookDTO.author(), bookDTO.description(), bookDTO.genre(), bookDTO.cover());
    }

    public static BookDTO entityToDTO(Book book) {
        return new BookDTO(book.getTitle(), book.getAuthor(), book.getDescription(), book.getGenre(), book.getCover());
    }
}

