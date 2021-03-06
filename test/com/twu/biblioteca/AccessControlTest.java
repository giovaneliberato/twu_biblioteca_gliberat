package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AccessControlTest {


    @Test
    public void testUserLogin() {
        List<User> users = new ArrayList<User>();
        User user = new User("000-0001", "password");
        users.add(user);
        AccessControl ac = new AccessControl(users);
        ac.doLogin("000-0001", "password");
        assertTrue(user.isLogged());
    }



    @Test
    public void testGetUserByLibraryNumber() {
        List<User> users = new ArrayList<User>();
        User targetUser = new User("000-0001", "password");
        users.add(targetUser);
        users.add(new User("000-0002", "password"));
        AccessControl ac = new AccessControl(users);
        assertEquals(targetUser, ac.getUserByLibraryNumber("000-0001"));
    }

}
