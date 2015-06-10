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
        for (Item item: getAvailableItems()){
            if (item.getCode().equals(code)){
                return item;
            }
        }
        throw new Error("That item is not available.");
    }


    public List<Item> getAvailableItems() {
        return filterAvailableItems(getItems());
    }

    public List<Item> getAvailableBooks() {
        return filterAvailableItems(books);
    }

    public List<Item> getAvailableMovies() {
        return filterAvailableItems(movies);
    }

    public Item getItemByCode(String code) {
        for (Item item: getItems()){
            if (item.getCode().equals(code)){
                return item;
            }
        }
        throw new Error("That item is not available.");
    }

    public void returnItemByCode(String code) {
        Item book = getItemByCode(code);
        book.setAvailable(true);
    }

    public List<Item> getMovies() {
        return movies;
    }

    private List<Item> filterAvailableItems(List<Item> itemList) {
        List<Item> availableItems = new ArrayList<Item>();
        for (Item item: itemList) {
            if (item.isAvailable()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<Item>();
        items.addAll(books);
        items.addAll(movies);
        return items;
    }
}
