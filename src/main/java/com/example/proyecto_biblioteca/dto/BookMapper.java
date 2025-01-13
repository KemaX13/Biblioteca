package com.example.proyecto_biblioteca.dto;

import com.example.proyecto_biblioteca.model.Book;

public class BookMapper {
    public static Book dtoEntity(BookDTO bookDTO){
        new Book(bookDTO.title(),bookDTO.author(), bookDTO.description(),bookDTO.genre(), bookDTO.cover());
    }
    public static BookDTO entityToDTO(Book book){
        new BookDTO(book.getTitle(), book.getAuthor(), book.getDescription(), book.getGenre(), book.getCover());
    }


}
