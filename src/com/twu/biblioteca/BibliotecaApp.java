package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(new Book("Book 1", "1", "1985", "Author"));
        books.add(new Book("Book 2", "2", "1985", "Author"));
        movies.add(new Movie("Movie 1", "3", "1985", "Director"));
        movies.add(new Movie("Movie 2", "4", "1985", "Director"));
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
