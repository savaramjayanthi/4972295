package com.example.demo.dto;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::bookToBookDTO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        return bookMapper.bookToBookDTO(bookRepository.save(book));
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        book.setId(id);
        return bookMapper.bookToBookDTO(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
