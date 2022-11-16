package com.client;

public class MainMenuOption1 {

    public static void onClick1() {
        System.out.printf("%-15s %-15s %-14s %-13s %-12s %-11s %-11s"
                ,"Vin Number", "Plate Number", "Car Type", "Price/Day", "Year", "Make", "Model");
        System.out.println();
        System.out.println();
        GlobalVariable.userInterface.getAllCars();
        try {
            GlobalVariable.invoiceReservation.inventoryPeeked();
        }
        catch (IllegalArgumentException e) {

        }
    }
}
