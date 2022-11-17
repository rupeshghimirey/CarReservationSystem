package com.client;

import static com.client.GlobalVariable.*;

public class MainMenuOption1 {

    public static void onClick1() {
        System.out.printf("%-10s %-15s %-15s %-14s %-13s %-12s %-11s %-11s",
                "", "Vin Number", "Plate Number", "Car Type", "Price/Day", "Year", "Make", "Model");
        System.out.println();
        System.out.println();
        userInterface.getAllCars();
        try {
            invoiceReservation.inventoryPeeked(userInterface.getCustomerInfo());
        }
        catch (IllegalArgumentException e) {

        }
    }
}
