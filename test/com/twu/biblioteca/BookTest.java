package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testBookAttributes() {
        String title = "A great book";
        String author = "A great author";
        String publishYear = "1985";
        Book book = new Book(title, author, publishYear);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(publishYear, book.getPublishYear());
    }
}
