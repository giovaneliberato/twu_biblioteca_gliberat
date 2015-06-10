package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Item> books = new LinkedList<Item>();
        books.add(Item.createBook("2", "Title", "1985", "Author"));
        Library library = new Library(books);

        CommandLineInterface cli = new CommandLineInterface(library);
        cli.start();
    }
}
