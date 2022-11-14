package com.crs.models;

import com.crs.datahub.CarInventory;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner;
    CarInventory carInventory = new CarInventory();

    public UserInterface() throws FileNotFoundException {
        myScanner = new Scanner(System.in);

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
        for(Car car: carInventory.getCarCollections().values()) {
            System.out.println(car);
        }
    }

    public String printSubMenuOfTwo() {
        System.out.println("(1) Balance \n");
        System.out.println("(2) Select Car \n");
        System.out.println("(3) Option 3 \n");
        System.out.println("(4) Option 4 \n");

        System.out.println("Please select either 1,2,3 or 4 \n");

        String choice = myScanner.nextLine();
        return choice;

    }
}
