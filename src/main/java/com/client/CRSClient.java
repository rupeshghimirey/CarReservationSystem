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
    private static final String MAIN_OPTION_1 = "1";
    private static final String MAIN_OPTION_2 = "2";
    private static final String MAIN_OPTION_3 = "3";
    public static final String SUB_OPTION_1 = "1";
    public static final String SUB_OPTION_2 = "2";
    public static final String SUB_OPTION_3 = "3";
    public static final String SUB_OPTION_4 = "4";

    private static Customer customer = new Customer("1", "Rupesh", "Ghimire", "123-456-7891",
            new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
            new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {});

    public static void main(String[] args) throws FileNotFoundException {

        GlobalVariable.userInterface = new UserInterface();
        GlobalVariable.invoiceReservation = new InvoiceReservation();

        while (GlobalVariable.isMenuRunning) {
            String userInput = GlobalVariable.userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase(MAIN_OPTION_1)) {
                MainMenuOption1.onClick1();
            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_2)) {
                MainMenuOption2.mainMenuOption2(customer);
            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_3)) {
                GlobalVariable.userInterface.thankYouMessage();

                GlobalVariable.invoiceReservation.closeFile();//may not be necessary

                GlobalVariable.isMenuRunning = false;
            }
        }
    }
}

