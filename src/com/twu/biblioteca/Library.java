package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;


public class Library {
    private List<Book> books;
    private HashMap<String, String> options = new HashMap<String, String>();


    public Library(List<Book> books) {
        this.books = books;
        options.put("1", "List Books");
    }


    public List<Book> getBooks() {
        return books;
    }

    public HashMap<String, String> getOptions() {
        return options;
    }
}
