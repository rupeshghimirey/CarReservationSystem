package com.crs.models;

import com.crs.datahub.CarInventory;

import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner;
    CarInventory carInventory = new CarInventory();

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
        System.out.println("(2) Reserve Car");
        System.out.println("(3) Exit");
        System.out.println("Please enter 1, 2 or 3 only!\n");
        String choice = myScanner.nextLine();
        return  choice;
    }

    public void getAllCars() {
        for(Car car: carInventory.getCarCollections()) {
            System.out.println(car);
        }
    }

    public String printSubMenuOfTwo() {
        System.out.println("(1) Option 1 \n");
        System.out.println("(2) Option 2 \n");
        System.out.println("(3) Option 3 \n");
        System.out.println("(4) Option 4 \n");

        System.out.println("Please select either 1,2,3 or 4 \n");

        String choice = myScanner.nextLine();
        return choice;

    }
}
