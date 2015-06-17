package com.twu.biblioteca;

import java.util.List;

public class AccessControl {
    private List<User> users;
    private User loggedUser;

    public AccessControl(List<User> users) {
        this.users = users;
    }

    public void doLogin(String libraryNumber, String password) {
        User user = getUserByLibraryNumber(libraryNumber);
        if (user.comparePassword(password)){
            user.setLogged(true);
            loggedUser = user;
        } else {
            throw new Error("User not found.");
        }
    }

    public User getUserByLibraryNumber(String libraryNumber) {
        for (User user: users) {
            if (user.getLibraryNumber().equals(libraryNumber)){
                return user;
            }
        }
        return null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
