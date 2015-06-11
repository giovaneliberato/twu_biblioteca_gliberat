package com.twu.biblioteca;

import java.util.List;

public class AccessControl {
    private List<User> users;

    public AccessControl(List<User> users) {
        this.users = users;
    }

    public void doLogin(String libraryNumber, String password) {
        User user = getUSerByLibraryNumber(libraryNumber);
        if (user.comparePassword(password)){
            user.setLogged(true);
        } else {
            throw new Error("User not found.");
        }
    }

    public User getUSerByLibraryNumber(String libraryNumber) {
        for (User user: users) {
            if (user.getLibraryNumber().equals(libraryNumber)){
                return user;
            }
        }
        return null;
    }
}
