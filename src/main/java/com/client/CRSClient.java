package com.client;

import java.io.FileNotFoundException;

import static com.client.GlobalInitialization.globeInitializationStart;
import static com.client.GlobalVariable.*;

public class CRSClient {
    public static void main(String[] args) throws FileNotFoundException {
        globeInitializationStart();

        while (true) {
            String userInput = userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase(MAIN_OPTION_1)) {

                MainMenuOption1.onClick1();

            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_2)) {

                DisplayUsersList.SwitchUserMenu();

            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_3)) {

                MainMenuOption2.mainMenuOption2();

            } else if (userInput.equalsIgnoreCase(MAIN_OPTION_4)) {
                userInterface.thankYouMessage();

                break;
            }
        }
    }
}

