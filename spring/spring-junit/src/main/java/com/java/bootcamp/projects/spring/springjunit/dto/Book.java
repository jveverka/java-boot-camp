package com.java.bootcamp.projects.spring.springjunit.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    private final String name;
    private final String author;
    private final Long price;

    @JsonCreator
    public Book(@JsonProperty("name") String name,
                @JsonProperty("author") String author,
                @JsonProperty("price") Long price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Long getPrice() {
        return price;
    }

}
