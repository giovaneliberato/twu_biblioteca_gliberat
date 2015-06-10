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


    private void getInputOption() {
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
            else if (option.equals("3")) {
                returnBook();
            }
            else if (option.equals("q")) {
                break;
            }
            else {
                System.out.println("Invalid option, try again.");
            }
        }


    }

    private void displayOptions() {
        System.out.println("1 - List Books");
        System.out.println("2 - Checkout Book");
        System.out.println("3 - Return Book");
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
        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        try {
            library.checkoutItemByCode(code);
            System.out.println("Thank You, enjoy the book!");
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }

    private void returnBook() {
        System.out.print("Enter book code: ");
        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        try {
            library.returnBookByCode(code);
            System.out.println("Thank you for returning the book.");
        } catch (Error e) {
            System.out.println(e.getMessage());
        }

    }
}
