package com.twu.biblioteca;

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
        for (Book book: books){
            if (book.getCode().equals(code)){
                return book;
            }
        }
        throw new Error("Book not found!");
    }
}
