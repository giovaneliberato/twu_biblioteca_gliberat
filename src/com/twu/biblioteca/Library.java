package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;


public class Library {
    private String welcomeMessage;
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public List<Book> getBooks() {
        return books;
    }
}
