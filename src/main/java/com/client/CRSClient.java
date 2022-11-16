package com.client;

import com.crs.customer.Address;
import com.crs.customer.CreditCard;
import com.crs.customer.Customer;
import com.crs.datahub.*;
import com.crs.models.CarCost;
import com.crs.models.UserInterface;

import java.io.FileNotFoundException;
import java.util.stream.Collectors;

public class CRSClient {
    public static void main(String[] args) throws FileNotFoundException {
        GlobalVariable.userInterface = new UserInterface();
        GlobalVariable.invoiceReservation = new InvoiceReservation();

        Customer customer1 = new Customer("1", "Rupesh", "Ghimire", "123-456-7891",
                new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
                new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {});

        while (GlobalVariable.isMenuRunning) {
            String userInput = GlobalVariable.userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase("1")) {
                MainMenuOption1.onClick1();
            } else if (userInput.equalsIgnoreCase("2")) {
                String subMenu2Choice = GlobalVariable.userInterface.printSubMenuOfTwo();
                GlobalVariable.isSubMenu2Choice = true;

                while (GlobalVariable.isSubMenu2Choice) {
                    if (subMenu2Choice.equals("1")) {
                        SubMenu2Choice1.subMenu2Choice1(customer1);

                        GlobalVariable.isSubMenu2Choice = false;
                    } else if (subMenu2Choice.equals("2")) {

                        SubMenu2Choice2.subMenu2Choice2(customer1);

                        GlobalVariable.isSubMenu2Choice = false;

                    } else if (subMenu2Choice.equals("3")) {
                        SubMenu2Choice3.subMenu2Choice3(customer1);

                        GlobalVariable.isSubMenu2Choice = false;
                    } else if (subMenu2Choice.equals("4")) {

                        System.out.println("You have selected FOUR!");
                        GlobalVariable.isSubMenu2Choice = false;
                    }
                }
            } else if (userInput.equalsIgnoreCase("3")) {
                System.out.println("Thank you for visiting CRS!");

                GlobalVariable.invoiceReservation.closeFile();//may not be necessary

                GlobalVariable.isMenuRunning = false;
            }
        }
    }
}

