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
    public void testGetBookByCode() {
        Library lib = createTestLibrary();
        Book book = lib.getBookByCode("1");
        assertNotNull(book);
        book = lib.getBookByCode("a");
        assertNull(book);
    }

    @Test
    public void testCheckoutBookByCode() {
        Library lib = createTestLibrary();
        Book book = lib.getBookByCode("1");
        assertTrue(book.isAvailable());
        lib.checkoutBookByCode("1");
        assertFalse(book.isAvailable());
    }

    private Library createTestLibrary() {
        List<Book> books = new LinkedList<Book>();
        books.add(new Book("1", "Book 1", "Author", "1985"));
        books.add(new Book("2", "Book 2", "Author", "1985"));
        return new Library(books);
    }
}
