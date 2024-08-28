package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;

    @JsonCreator
    public BookDTO(@JsonProperty("id") Long id,
                   @JsonProperty("title") String title,
                   @JsonProperty("author") String author,
                   @JsonProperty("price") double price,
                   @JsonProperty("isbn") String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }
}

