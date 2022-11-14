package com.client;

import com.crs.customer.Address;
import com.crs.customer.CreditCard;
import com.crs.customer.Customer;
import com.crs.customer.IPayment;
import com.crs.datahub.CarInventory;
import com.crs.models.Car;
import com.crs.models.CarType;
import com.crs.models.UserInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CRSClient {
    private UserInterface userInterface;

    private Customer customer;

    public CRSClient(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.customer = customer;
    }

    public static void main(String[] args) {

        boolean isMenuRunning = true;
        UserInterface userInterface = new UserInterface();
        Customer customer1 = new Customer("1", "Rupesh", "123-456-7891",
                new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
                new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {
            @Override
            public void pay() {
                System.out.println("CC");
            }
        });

        while (isMenuRunning) {
            String userInput = userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase("1")) {
                userInterface.getAllCars();
            } else if (userInput.equalsIgnoreCase("2")) {
                boolean isSubMenu2Choice = true;
                String subMenu2Choice = userInterface.printSubMenuOfTwo();
                while (isSubMenu2Choice) {
                    if (subMenu2Choice.equals("1")) {
                        System.out.println("Your current Balance is: " + customer1.getBalance());
                        isSubMenu2Choice = false;
                    } else if (subMenu2Choice.equals("2")) {
                        System.out.println("You have selected TWO!");
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
                isMenuRunning = false;
            }
        }
    }
}
