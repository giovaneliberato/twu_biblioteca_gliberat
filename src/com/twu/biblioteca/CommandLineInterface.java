package com.twu.biblioteca;


import java.util.Scanner;

public class CommandLineInterface {

    private Library library;
    private AccessControl accessControl;

    public CommandLineInterface(Library library, AccessControl accessControl) {
        this.library = library;
        this.accessControl = accessControl;
    }

    public void start() {
        System.out.println("Welcome to bangalore public library!");
        getInputOption();
    }


    private void getInputOption() {
        while (true){
            showMenu();
            System.out.print("Choose an option: ");
            String option = getInput();
            if (option.equals("1")) {
                displayBookList();
            }
            else if (option.equals("2")) {
                doLogin();
                checkoutBook();
            }
            else if (option.equals("3")) {
                doLogin();
                returnBook();
            }
            else if (option.equals("4")) {
                displayMovieList();
            }
            else if (option.equals("5")) {
                doLogin();
                checkoutMovie();
            }
            else if (option.equals("6")) {
                doLogin();
                returnMovie();
            }
            else if (option.equals("q")) {
                break;
            }
            else {
                System.out.println("Invalid option, try again.");
            }
        }


    }

    private void showMenu() {
        System.out.println();
        System.out.println("---Menu---");
        System.out.println("1 - List Books");
        System.out.println("2 - Checkout Book");
        System.out.println("3 - Return Book");
        System.out.println("4 - List Movies");
        System.out.println("5 - Checkout Movie");
        System.out.println("6 - Return Movie");
        System.out.println("q - Quit");
    }

    private void displayBookList() {
        System.out.println("List of available books:");
        for (Item book: library.getAvailableBooks()) {
            System.out.println(book);
        }
    }

    private void checkoutBook() {
        System.out.print("Enter book code: ");
        String code = getInput();
        try {
            library.checkoutItemByCode(code, accessControl.getLoggedUser());
            System.out.println("Thank You, enjoy the book!");
        } catch (Error e) {
            System.out.println("That book is not available.");
        }
    }

    private void returnBook() {
        System.out.print("Enter book code: ");
        String code = getInput();
        try {
            library.returnItemByCode(code);
            System.out.println("Thank you for returning the book.");
        } catch (Error e) {
            System.out.println("That book is not available.");
        }
    }

    private void displayMovieList() {
        System.out.println("List of available movies:");
        for (Item movie: library.getAvailableMovies()) {
            System.out.println(movie);
        }
    }

    private void checkoutMovie() {
        System.out.print("Enter movie code: ");
        String code = getInput();
        try {
            library.checkoutItemByCode(code, accessControl.getLoggedUser());
            System.out.println("Thank You, enjoy the movie!");
        } catch (Error e) {
            System.out.println("That movie is not available.");
        }
    }

    private void returnMovie() {
        System.out.print("Enter movie code: ");
        String code = getInput();
        try {
            library.returnItemByCode(code);
            System.out.println("Thank you for returning the movie.");
        } catch (Error e) {
            System.out.println("That movie is not available.");
        }
    }

    private void doLogin() {
        if (accessControl.getLoggedUser() != null) {
            return;
        }
        while (true){
            System.out.println("---Login---a");
            System.out.print("Enter your library code: ");
            String libraryCode = getInput();
            System.out.print("Enter your password: ");
            String password = getInput();
            try{
                accessControl.doLogin(libraryCode, password);
                System.out.println("You are logged in!");
                break;
            } catch (Error e){
                System.out.println("User not found.");
            }
        }
    }

    private String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
