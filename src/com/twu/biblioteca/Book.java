package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String publishYear;
    private String code;
    private boolean available = true;

    public Book(String code, String title, String author, String publishYear) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    @Override
    public String toString(){
        return "code: " + code + " | " + title + " - " + author + " - " + publishYear;
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

    public String getCode() {
        return code;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }
}
