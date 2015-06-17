package com.twu.biblioteca;

public class Book extends Item {
    private String author;

    public Book(String code, String title, String year, String author) {
        super(code, title, year);
        this.author = author;
    }

    @Override
    public String toString(){
        return "Code: " + getCode() + " | " + getTitle() + " | " + getYear() + " | " + author;
    }
}
