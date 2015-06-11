package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean logged = false;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder information = new StringBuilder("Library number: " + libraryNumber);
        information.append(" | Name: " + name);
        information.append(" | Email: " + email);
        information.append(" | Phone Number: " + phoneNumber);
        return information.toString();
    }

    public void updateProfile(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

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
