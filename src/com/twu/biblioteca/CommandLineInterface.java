package com.twu.biblioteca;

import java.util.HashMap;

public class CommandLineInterface {

    private Library library;

    public CommandLineInterface(Library library) {
        this.library = library;
    }

    public void start() {
        System.out.println();
        displayBookList();
    }

    public void displayBookList() {
        System.out.println("List of available books:");
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
