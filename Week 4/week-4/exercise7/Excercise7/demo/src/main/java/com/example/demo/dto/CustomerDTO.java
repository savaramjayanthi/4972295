package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;
}

