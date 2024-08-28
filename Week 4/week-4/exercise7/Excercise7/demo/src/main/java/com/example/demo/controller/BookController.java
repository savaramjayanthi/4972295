package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BooksListRetrieved");
        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookRetrieved");
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/books/" + savedBook.getId());
        return new ResponseEntity<>(savedBook, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        book.setId(id);
        Book updatedBook = bookRepository.save(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookUpdated");
        return new ResponseEntity<>(updatedBook, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookDeleted");
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}


