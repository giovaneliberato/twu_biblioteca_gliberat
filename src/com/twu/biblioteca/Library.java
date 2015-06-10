package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Item> books;
    private List<Item> movies;


    public Library(List<Item> books) {
        this.books = books;
    }

    public List<Item> getBooks() {
        return books;
    }

    public void checkoutBookByCode(String code) {
        Item book = getAvailableItemByCode(code);
        book.setAvailable(false);
    }

    public Item getAvailableItemByCode(String code) {
        for (Item book: getAvailableBooks()){
            if (book.getCode().equals(code)){
                return book;
            }
        }
        throw new Error("That book is not available.");
    }

    public Item getBookByCode(String code) {
        for (Item book: books){
            if (book.getCode().equals(code)){
                return book;
            }
        }
        throw new Error("That book is not available.");
    }

    public List<Item> getAvailableBooks() {
        List<Item> availableBooks = new ArrayList<Item>();
        for (Item book: books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public void returnBookByCode(String code) {
        Item book = getBookByCode(code);
        book.setAvailable(true);
    }

    public List<Item> getMovies() {
        return movies;
    }


}
