package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> books;


    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void checkoutBookByCode(String code) {
        Book book = getBookByCode(code);
        book.setAvailable(false);
    }

    public Book getBookByCode(String code) {
        for (Book book: getAvailableBooks()){
            if (book.getCode().equals(code)){
                return book;
            }
        }
        throw new Error("That book is not available.");
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book: books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
