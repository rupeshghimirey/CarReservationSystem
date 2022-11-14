package com.crs.models;

import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner;

    public UserInterface() {
        myScanner = new Scanner(System.in);
        this.myScanner = myScanner;
    }
    // main menu
    public String printMainMenu() {
        System.out.println("\n***************************************");
        System.out.println("Welcome to Car Reservation System (CRS)");
        System.out.println("***************************************");
        System.out.println("(1) Car Inventory");
        System.out.println("(2) Reserve");
        System.out.println("(3) Exit");
    //Test
        System.out.println("Please enter 1, 2 or 3 only!\n");
        String choice = myScanner.nextLine();
        return  choice;
    }
}
