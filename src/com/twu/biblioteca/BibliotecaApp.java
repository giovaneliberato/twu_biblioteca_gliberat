package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new Book("2", "Title", "Author", "1985"));
        Library library = new Library(books);

        CommandLineInterface cli = new CommandLineInterface(library);
        cli.start();
    }
}
