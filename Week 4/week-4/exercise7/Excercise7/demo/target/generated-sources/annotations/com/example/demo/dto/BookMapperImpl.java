package com.example.demo.dto;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T19:53:47+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        String author = null;
        Long id = null;
        String isbn = null;
        double price = 0.0d;
        String title = null;

        author = book.getAuthor();
        id = book.getId();
        isbn = book.getIsbn();
        if ( book.getPrice() != null ) {
            price = book.getPrice();
        }
        title = book.getTitle();

        BookDTO bookDTO = new BookDTO( id, title, author, price, isbn );

        return bookDTO;
    }

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( bookDTO.getAuthor() );
        book.setId( bookDTO.getId() );
        book.setIsbn( bookDTO.getIsbn() );
        book.setPrice( bookDTO.getPrice() );
        book.setTitle( bookDTO.getTitle() );

        return book;
    }
}
