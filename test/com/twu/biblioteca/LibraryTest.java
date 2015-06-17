package com.twu.biblioteca;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testListAllBooks() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        books.add(Item.createBook("2", "Book 2", "1985", "Author"));
        Library lib = new Library(books, movies);
        assertEquals(2, lib.getBooks().size());
    }

    @Test
    public void testListAllMovies() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        movies.add(Item.createBook("1", "Book 1", "1985", "Author"));
        movies.add(Item.createBook("2", "Book 2", "1985", "Author"));
        Library lib = new Library(books, movies);
        assertEquals(2, lib.getMovies().size());
    }

    @Test
    public void testListAllItems() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        books.add(Item.createBook("2", "Book 2", "1985", "Author"));
        movies.add(Item.createMovie("3", "Movie 1", "1985", "Director"));
        movies.add(Item.createMovie("4", "Movie 2", "1985", "Director"));
        Library lib = new Library(books, movies);
        assertEquals(4, lib.getItems().size());
    }

    @Test
    public void testListOnlyAvailableBooks() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        books.add(Item.createBook("2", "Book 2", "1985", "Author"));
        Library lib = new Library(books, movies);
        assertEquals(2, lib.getAvailableBooks().size());

        User user = new User("000-0001", "password");
        lib.checkoutItemByCode("1", user);
        assertEquals(1, lib.getAvailableBooks().size());
    }

    @Test
    public void testListOnlyAvailableMovies() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        movies.add(Item.createMovie("1", "Movie 1", "1985", "Director"));
        movies.add(Item.createMovie("2", "Movie 2", "1985", "Director"));
        Library lib = new Library(books, movies);
        assertEquals(2, lib.getAvailableMovies().size());

        User user = new User("000-0001", "password");
        lib.checkoutItemByCode("1", user);
        assertEquals(1, lib.getAvailableMovies().size());
    }

    @Test
    public void testListOnlyAvailableItems() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        books.add(Item.createBook("2", "Book 2", "1985", "Author"));
        movies.add(Item.createMovie("3", "Movie 1", "1985", "Director"));
        movies.add(Item.createMovie("4", "Movie 2", "1985", "Director"));
        Library lib = new Library(books, movies);

        User user = new User("000-0001", "password");
        assertEquals(4, lib.getAvailableItems().size());
        lib.checkoutItemByCode("1", user);
        lib.checkoutItemByCode("3", user);
        assertEquals(2, lib.getAvailableItems().size());

    }

    @Test
    public void testGetItemByCode() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        Item book = Item.createBook("1", "Book 1", "1985", "Author");
        books.add(book);
        Library lib = new Library(books, movies);
        Item item = lib.getAvailableItemByCode("1");
        assertEquals(book, item);
    }

    @Test
    public void testCheckoutItemByCode() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        movies.add(Item.createMovie("2", "Movie 1", "1985", "Director"));
        Library lib = new Library(books, movies);
        User user = new User("000-0001", "password");

        Item book = lib.getAvailableItemByCode("1");
        assertTrue(book.isAvailable());
        lib.checkoutItemByCode("1", user);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testItemCheckoutUser() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        Library lib = new Library(books, movies);
        User user = new User("000-0001", "password");

        Item item = lib.getAvailableItemByCode("1");
        lib.checkoutItemByCode("1", user);
        assertEquals(user, item.getCheckoutUser());
    }

    @Test
    public void testReturnItem() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        Item book = Item.createBook("1", "Book 1", "1985", "Author");
        books.add(book);
        Library lib = new Library(books, movies);
        book.setAvailable(false);
        lib.returnItemByCode("1");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testReturnItemCleansCheckoutUser() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        Item book = Item.createBook("1", "Book 1", "1985", "Author");
        books.add(book);
        User user = new User("000-0001", "password");
        Library lib = new Library(books, movies);

        lib.checkoutItemByCode("1", user);
        lib.returnItemByCode("1");
        assertNull(book.getCheckoutUser());
    }

    @Test
    public void testReturnedItemAppearsOnList() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        Item book = Item.createBook("1", "Book 1", "1985", "Author");
        books.add(book);
        books.add(Item.createBook("2", "Book 2", "1985", "Author"));
        Library lib = new Library(books, movies);
        book.setAvailable(false);
        assertEquals(1, lib.getAvailableBooks().size());
        lib.returnItemByCode("1");
        assertEquals(2, lib.getAvailableBooks().size());
    }

}
