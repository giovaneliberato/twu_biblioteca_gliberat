package com.twu.biblioteca;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testListAllBooks() {
        Library lib = createTestLibrary();
        assertEquals(2, lib.getBooks().size());
    }

    @Test
    public void testListAllMovies() {
        Library lib = createTestLibrary();
        assertEquals(2, lib.getMovies().size());
    }

    @Test
    public void testListAllItems() {
        Library lib = createTestLibrary();
        assertEquals(4, lib.getItems().size());
    }

    @Test
    public void testListOnlyAvailableBooks() {
        Library lib = createTestLibrary();
        User user = createTestUser();
        assertEquals(2, lib.getAvailableBooks().size());
        lib.checkoutItemByCode("1", user);
        assertEquals(1, lib.getAvailableBooks().size());
    }

    @Test
    public void testListOnlyAvailableMovies() {
        Library lib = createTestLibrary();
        User user = createTestUser();
        assertEquals(2, lib.getAvailableMovies().size());
        lib.checkoutItemByCode("3", user);
        assertEquals(1, lib.getAvailableMovies().size());
    }

    @Test
    public void testListOnlyAvailableItems() {
        Library lib = createTestLibrary();
        User user = createTestUser();
        assertEquals(4, lib.getAvailableItems().size());
        lib.checkoutItemByCode("1", user);
        lib.checkoutItemByCode("3", user);
        assertEquals(2, lib.getAvailableItems().size());

    }

    @Test
    public void testGetItemByCode() {
        Library lib = createTestLibrary();
        Item item = lib.getAvailableItemByCode("1");
        assertNotNull(item);
    }

    @Test
    public void testCheckoutItemByCode() {
        Library lib = createTestLibrary();
        User user = createTestUser();
        Item book = lib.getAvailableItemByCode("1");
        assertTrue(book.isAvailable());
        lib.checkoutItemByCode("1", user);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testItemCheckoutUser() {
        User user = createTestUser();
        Library lib = createTestLibrary();
        Item item = lib.getAvailableItemByCode("1");
        lib.checkoutItemByCode("1", user);
        assertEquals(user, item.getCheckoutUser());
    }

    @Test
    public void testReturnItem() {
        Library lib = createTestLibrary();
        Item book = lib.getItemByCode("1");
        book.setAvailable(false);
        lib.returnItemByCode("1");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testReturnedItemAppearsOnList() {
        Library lib = createTestLibrary();
        Item book = lib.getItemByCode("1");
        book.setAvailable(false);
        assertEquals(1, lib.getAvailableBooks().size());
        lib.returnItemByCode("1");
        assertEquals(2, lib.getAvailableBooks().size());
    }

    private Library createTestLibrary() {
        List<Item> books = new LinkedList<Item>();
        List<Item> movies = new LinkedList<Item>();
        books.add(Item.createBook("1", "Book 1", "1985", "Author"));
        books.add(Item.createBook("2", "Book 2", "1985", "Author"));
        movies.add(Item.createMovie("3", "Movie 1", "1985", "Director"));
        movies.add(Item.createMovie("4", "Movie 2", "1985", "Director"));
        return new Library(books, movies);
    }

    private User createTestUser() {
        return new User("000-0001", "password");

    }
}
