package com.twu.biblioteca;

public abstract class Item {
    private boolean available = true;
    private String code;
    private String title;
    private String year;
    private User checkoutUser;

    public Item(String code, String title, String year) {
        this.code = code;
        this.title = title;
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getCheckoutUser() {
        return checkoutUser;
    }

    public void setCheckoutUser(User checkoutUser) {
        this.checkoutUser = checkoutUser;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public void returnItem(){
        setAvailable(true);
        setCheckoutUser(null);
    };
}
