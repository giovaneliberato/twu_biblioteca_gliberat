package com.twu.biblioteca;

public class Item {
    private boolean available = true;
    private String title;
    private String code;
    private String author;
    private String director;
    private String year;

    public Item() {}

    protected Item(String code, String title, String year, String author, String director) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.year = year;
        this.director = director;
    }

    @Override
    public String toString() {
        String owner;
        if (author != null)
            owner = author;
        else
            owner = director;

        return "Code: " + code + " | " + title + " | " + year + " | " + owner;
    }

    public static Item createBook(String code, String title, String year, String author) {
        return new Item(code, title, year, author, null);
    }

    public static Item createMovie(String code, String title, String year, String director) {
        return new Item(code, title, year, null, director);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }
}
