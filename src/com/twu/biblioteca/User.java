package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private boolean logged = false;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean comparePassword(String password) {
        return this.password.equals(password);
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
