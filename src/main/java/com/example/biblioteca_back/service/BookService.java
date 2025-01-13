package com.example.biblioteca_back.service;

import com.example.biblioteca_back.model.Book;
import com.example.biblioteca_back.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Encontrar libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksWithoutDescription() {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            book.setDescription(null); // Establecer la descripción a null
        }
        return books;
    }

    public Optional<Book> findByTitleIgnoreCase(String title) {
        return bookRepository.findByTitleIgnoreCase(title);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Book> findBooksByGenre(String genre) {
        return bookRepository.findByGenreContainingIgnoreCase(genre);
    }

    public Optional<Book> findBook(int id) {
        return bookRepository.findById(id);
    }

    // Agregar libro
    public Book addBooks(Book newBook) {
        return bookRepository.save(newBook);
    }

    // Actualizar libros
    public Optional<Book> updatedBook(int id, Book updatedBook) {
        Optional<Book> foundBook = bookRepository.findById(id);

        if (foundBook.isPresent()) {
            Book existingBook = foundBook.get();

            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setCover(updatedBook.getCover());

            return Optional.of(bookRepository.save(existingBook));
        }

        return Optional.empty();
    }

    // Eliminar libros
    public void deleteBooksById(List<Integer> ids) {
        bookRepository.deleteAllById(ids);
    }
}
