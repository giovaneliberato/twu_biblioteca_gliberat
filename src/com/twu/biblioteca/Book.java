package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String publishYear;

    public Book(String title, String author, String publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    @Override
    public String toString(){
        return title + " - " + author + " - " + publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public String getTitle() {
        return title;
    }
}
