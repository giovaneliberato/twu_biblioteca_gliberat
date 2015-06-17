package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(new Book("1", "Book 1", "1985", "Author"));
        books.add(new Book("2", "Book 2", "1985", "Author"));
        movies.add(new Movie("3", "Movie 1", "1985", "Director"));
        movies.add(new Movie("4", "Movie 2", "1985", "Director"));
        Library library = new Library(books, movies);

        List<User> users = new ArrayList<User>();
        User user1 = new User("000-0001", "password");
        user1.updateProfile("Giovane", "g@example.com", "123456");
        users.add(user1);
        AccessControl ac = new AccessControl(users);

        CommandLineInterface cli = new CommandLineInterface(library, ac);
        cli.start();
    }
}
