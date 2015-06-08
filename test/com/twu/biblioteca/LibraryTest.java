package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    Library lib;

    @Before
    public void setUp() {
        List<Book> books = new LinkedList<Book>();
        books.add(new Book("Title", "Author", "1985"));
        lib = new Library(books);
    }

    @Test
    public void testGetAllBooks() {
        boolean isNotEmpty = lib.getBooks().size() > 0;
        assertTrue(isNotEmpty);
    }


}
