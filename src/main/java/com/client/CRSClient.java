package com.client;

import com.crs.datahub.*;
import com.crs.models.UserInterface;

import java.io.FileNotFoundException;

import static com.client.GlobalVariable.*;

public class CRSClient {


    public static void main(String[] args) throws FileNotFoundException {

        userInterface = new UserInterface();
        invoiceReservation = new InvoiceReservation();

        while (isMenuRunning) {
            String userInput = userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase(MAIN_OPTION_1)) {

                MainMenuOption1.onClick1();

            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_2)) {

                SubMenu2Choice1.subMenu2Choice1();

            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_3)) {

                MainMenuOption2.mainMenuOption2();

            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_4)) {
                userInterface.thankYouMessage();

                invoiceReservation.closeFile();//may not be necessary

                isMenuRunning = false;
            }
        }
    }
}

