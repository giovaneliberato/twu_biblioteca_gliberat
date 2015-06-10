package com.twu.biblioteca;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testGetAllBooks() {
        Library lib = createTestLibrary();
        assertNotNull(lib.getBooks());
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
        Item book = lib.getAvailableItemByCode("1");
        assertTrue(book.isAvailable());
        lib.checkoutItemByCode("1");
        assertFalse(book.isAvailable());
    }

    @Test
    public void testListOnlyAvailableBooks() {
        Library lib = createTestLibrary();
        assertEquals(2, lib.getAvailableBooks().size());
        lib.checkoutItemByCode("1");
        assertEquals(1, lib.getAvailableBooks().size());
    }

    @Test
    public void testReturnItem() {
        Library lib = createTestLibrary();
        Item book = lib.getItemByCode("1");
        book.setAvailable(false);
        lib.returnBookByCode("1");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testReturnedItemAppearsOnList() {
        Library lib = createTestLibrary();
        Item book = lib.getItemByCode("1");
        book.setAvailable(false);
        assertEquals(1, lib.getAvailableBooks().size());
        lib.returnBookByCode("1");
        assertEquals(2, lib.getAvailableBooks().size());
    }

    @Test
    public void testListAllMovies() {
        Library lib = createTestLibrary();
        assertNotNull(lib.getMovies());
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
}
