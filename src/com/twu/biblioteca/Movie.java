package com.twu.biblioteca;

public class Movie extends Item {
    private String director;

    public Movie(String code, String title, String year, String director) {
        super(code, title, year);
        this.director = director;
    }

    @Override
    public String toString(){
        return "Code: " + getCode() + " | " + getTitle() + " | " + getYear() + " | " + director;
    }
}
