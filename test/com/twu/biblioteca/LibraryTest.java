package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    @Test
    public void testGetAllBooks() {
        Library lib = createStubLibrary();
        assertNotNull(lib.getBooks());
    }

    @Test
    public void testGetOptions() {
        Library lib = createStubLibrary();
        HashMap<String, String> options = lib.getOptions();
        assertNotNull(options);
    }

    private Library createStubLibrary() {
        List<Book> books = new LinkedList<Book>();
        books.add(new Book("Title", "Author", "1985"));
        return new Library(books);
    }

}
