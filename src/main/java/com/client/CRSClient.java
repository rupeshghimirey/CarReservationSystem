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
    private static final String MAIN_OPTION_3 = "2";
    private static final String SUB_OPTION_1 = "1";
    private static final String SUB_OPTION_2 = "2";
    private static final String SUB_OPTION_3 = "3";
    private static final String SUB_OPTION_4 = "4";
    public static void main(String[] args) throws FileNotFoundException {
        GlobalVariable.userInterface = new UserInterface();
        GlobalVariable.invoiceReservation = new InvoiceReservation();

        while (GlobalVariable.isMenuRunning) {
            String userInput = GlobalVariable.userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase(MAIN_OPTION_1)) {
                MainMenuOption1.onClick1();
            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_2)) {
                String subMenu2Choice = GlobalVariable.userInterface.printSubMenuOfTwo();
                GlobalVariable.isSubMenu2Choice = true;

                while (GlobalVariable.isSubMenu2Choice) {
                    if (subMenu2Choice.equals(SUB_OPTION_1)) {
                        SubMenu2Choice1.subMenu2Choice1(GlobalVariable.userInterface.getCustomerInfo());

                        GlobalVariable.isSubMenu2Choice = false;
                    } else if (subMenu2Choice.equals(SUB_OPTION_2)) {

                        SubMenu2Choice2.subMenu2Choice2(GlobalVariable.userInterface.getCustomerInfo());

                        GlobalVariable.isSubMenu2Choice = false;

                    } else if (subMenu2Choice.equals(SUB_OPTION_3)) {
                        SubMenu2Choice3.subMenu2Choice3(GlobalVariable.userInterface.getCustomerInfo());

                        GlobalVariable.isSubMenu2Choice = false;
                    } else if (subMenu2Choice.equals(SUB_OPTION_4)) {

                        GlobalVariable.isSubMenu2Choice = false;
                    }
                }
            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_3)) {
                GlobalVariable.userInterface.thankYouMessage();

                GlobalVariable.invoiceReservation.closeFile();//may not be necessary

                GlobalVariable.isMenuRunning = false;
            }
        }
    }
}

