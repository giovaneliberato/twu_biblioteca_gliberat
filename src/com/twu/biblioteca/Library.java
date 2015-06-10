package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Item> books;
    private List<Item> movies;


    public Library(List<Item> books, List<Item> movies) {
        this.books = books;
        this.movies = movies;
    }

    public List<Item> getBooks() {
        return books;
    }

    public void checkoutItemByCode(String code) {
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

    public List<Item> getAvailableBooks() {
        return getAvailableItems(books);
    }

    public List<Item> getAvailableMovies() {
        return getAvailableItems(movies);
    }

    public Item getItemByCode(String code) {
        for (Item book: books){
            if (book.getCode().equals(code)){
                return book;
            }
        }
        throw new Error("That book is not available.");
    }

    public void returnBookByCode(String code) {
        Item book = getItemByCode(code);
        book.setAvailable(true);
    }

    public List<Item> getMovies() {
        return movies;
    }

    private List<Item> getAvailableItems(List<Item> itemList) {
        List<Item> availableItems = new ArrayList<Item>();
        for (Item item: itemList) {
            if (item.isAvailable()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

}
