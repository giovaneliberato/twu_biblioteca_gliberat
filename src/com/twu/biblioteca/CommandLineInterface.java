package com.twu.biblioteca;


import java.util.Scanner;

public class CommandLineInterface {

    private Library library;

    public CommandLineInterface(Library library) {
        this.library = library;
    }

    public void start() {
        System.out.println("Welcome to bangalore public library!");
        getInputOption();
    }


    public void getInputOption() {
        while (true){
            System.out.println();
            System.out.println("---Menu---");
            displayOptions();
            System.out.print("Choose an option: ");

            Scanner in = new Scanner(System.in);
            String option = in.nextLine();
            if (option.equals("1")) {
                displayBookList();
            }
            else if (option.equals("2")) {
                checkoutBook();
            }
            else if (option.equals("q")) {
                break;
            }
            else {
                System.out.println("Invalid option, try again.");
            }
        }


    }

    public void displayOptions() {
        System.out.println("1 - List Books");
        System.out.println("2 - Checout Book");
        System.out.println("q - Quit");

    }

    public void displayBookList() {
        System.out.println("List of available books:");
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }

    public void checkoutBook() {
        System.out.print("Enter book code: ");
        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        try {
            library.checkoutBookByCode(code);
            System.out.println("Thank You, enjoy the book!");
        } catch (Error e) {
            System.out.print("System error: ");
            System.out.println(e.getMessage());
        }
    }
}
