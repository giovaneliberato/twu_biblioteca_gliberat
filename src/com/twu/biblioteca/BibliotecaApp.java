package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        books.add(Item.createBook("2", "Book 2", "1985", "Author"));
        movies.add(Item.createMovie("3", "Movie 1", "1985", "Director"));
        movies.add(Item.createMovie("4", "Movie 2", "1985", "Director"));
        Library library = new Library(books, movies);

        CommandLineInterface cli = new CommandLineInterface(library);
        cli.start();
    }
}
