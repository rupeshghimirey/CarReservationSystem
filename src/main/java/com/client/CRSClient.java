package com.client;

import com.crs.customer.Address;
import com.crs.customer.CreditCard;
import com.crs.customer.Customer;
import com.crs.datahub.CarInventory;
import com.crs.datahub.InvoiceReservation;
import com.crs.datahub.ReservedPeriods;
import com.crs.models.Car;
import com.crs.models.CarCost;
import com.crs.models.UserInterface;

import java.io.FileNotFoundException;


public class CRSClient {
    private UserInterface userInterface;

    public CRSClient(UserInterface userInterface, CarInventory carInventory) throws FileNotFoundException {
        this.userInterface = userInterface;
    }

    public static void main(String[] args) throws FileNotFoundException {
        CarInventory carInventory = new CarInventory();
        InvoiceReservation invoiceReservation = new InvoiceReservation();


        boolean isMenuRunning = true;
        UserInterface userInterface = new UserInterface();
        Customer customer1 = new Customer("1", "Rupesh", "Ghimire", "123-456-7891",
                new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
                new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {

                });

        while (isMenuRunning) {
            String userInput = userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase("1")) {
                System.out.printf("%-10s %-15s %-15s %-14s %-13s %-12s %-11s %-11s",
                        "","Vin Number", "Plate Number", "Car Type", "Price/Day", "Year", "Make", "Model");
                System.out.println();
                System.out.println();
                userInterface.getAllCars();
                invoiceReservation.inventoryPeeked();
            } else if (userInput.equalsIgnoreCase("2")) {
                boolean isSubMenu2Choice = true;
                String subMenu2Choice = userInterface.printSubMenuOfTwo();
                while (isSubMenu2Choice) {
                    if (subMenu2Choice.equals("1")) {
                        System.out.println("Your current Balance is: " + customer1.getBalance());
                        System.out.println("(1) Add more Balance");

                        String addMoreBalance = userInterface.userInput();
                        if (addMoreBalance.equals("1")) {
                            System.out.println("How much you want to put?");
                            String addAmount = userInterface.userInput();

                            try {
                                customer1.setBalance(customer1.getBalance() + Double.parseDouble(addAmount));
                                System.out.println("Success");
                                System.out.println("New balance: $" + customer1.getBalance());

                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage() + "\nInvalid input");
                            }
                        }

                        System.out.println("(2) Previous Menu");
                        isSubMenu2Choice = false;
                    } else if (subMenu2Choice.equals("2")) {
                        System.out.println("Please input the starting date");
                        String startDate = userInterface.userInput();
                        System.out.println("Please input the end date");
                        String endDate = userInterface.userInput();

                        ReservedPeriods newPeriod1 = userInterface.inputReservedPeriod(startDate, endDate);
                        System.out.printf("%-10s %-15s %-15s %-14s %-13s %-12s %-11s %-11s",
                                "Car Index","Vin Number", "Plate Number", "Car Type", "Price/Day", "Year", "Make", "Model");
                        System.out.println();
                        System.out.println();
                        int i = 0;
                        for (Car c : userInterface.getAvailableCars(newPeriod1)) {
                            System.out.println(++i + " " + c.toString());
                        }

                        boolean flag = true;
                        String selectedCarIndex;
                        do {
                            System.out.println("Please select the car index to reserve");
                            selectedCarIndex = userInterface.userInput();
                            try {
                                int j = Integer.parseInt(selectedCarIndex);
                                if (j > 0 && j <= i) {
                                    flag = false;
                                } else {
                                    System.out.println("Invalid input!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        while (flag);

                        Car c = userInterface.selectCar(newPeriod1, selectedCarIndex);
                        // invoice when a car is selected
                        invoiceReservation.selectCar();
                        double charges = CarCost.totalCharge(c, newPeriod1.getTotalReservedDays());

                        if (charges > customer1.getBalance()) {
                            System.out.println("Not enough balance on " + customer1.getFirstName() + " " + customer1.getLastName() + " account!");
                            System.out.println("Press 1 to add more balance.");
                        } else {

                            c.inputPeriod(newPeriod1);
                            System.out.println(c.getVin() + " " + c.getMake() + " " + c.getModel() + " " + "Successfully Reserved!");

                            customer1.setBalance(customer1.getBalance() - charges);
                            System.out.println(customer1.getFirstName() + " " + customer1.getLastName() + " is charged: $" + charges);
                            System.out.println("Current balance: $" + customer1.getBalance());
                        }

                        isSubMenu2Choice = false;

                    } else if (subMenu2Choice.equals("3")) {
                        System.out.println("You have selected THREE!");
                        isSubMenu2Choice = false;

                    } else if (subMenu2Choice.equals("4")) {
                        System.out.println("You have selected FOUR!");
                    }

                }

            } else if (userInput.equalsIgnoreCase("3")) {
                System.out.println("Thank you for visiting CRS!");
                invoiceReservation.closeFile();
                isMenuRunning = false;
            }
        }
    }
}
