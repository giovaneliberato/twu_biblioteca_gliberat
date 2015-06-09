package com.twu.biblioteca;


import java.util.Scanner;

public class CommandLineInterface {

    private Library library;

    public CommandLineInterface(Library library) {
        this.library = library;
    }

    public void start() {
        System.out.println("Welcome to bangalore public library!");
        displayOptions();
        getInputOption();
    }

    public void displayOptions() {
        System.out.println("1 - List Books");

    }

    public void getInputOption() {
        boolean invalidOption;
        do {
            invalidOption = false;
            System.out.print("Choose an option: ");
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            switch (option) {
                case 1:
                    displayBookList();
                    break;
                default:
                    invalidOption = true;
                    System.out.println("Invalid option, try again.");
                    break;
            }
        } while (invalidOption != false);


    }

    public void displayBookList() {
        System.out.println("List of available books:");
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
