package com.client;

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

    public CRSClient(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public static void main(String[] args) {

        boolean isMenuRunning = true;
        UserInterface userInterface = new UserInterface();

        while (isMenuRunning) {
            String userInput = userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase("1")) {
                userInterface.getAllCars();
            } else if (userInput.equalsIgnoreCase("2")) {
                boolean isSubMenu2Choice = true;
                String subMenu2Choice = userInterface.printSubMenuOfTwo();
                while(isSubMenu2Choice) {
                    if(subMenu2Choice.equals("1")) {
                        System.out.println("You have selected ONE!");
                        isSubMenu2Choice = false;
                    } else if(subMenu2Choice.equals("2")) {
                        System.out.println("You have selected TWO!");
                        isSubMenu2Choice = false;

                    }else if(subMenu2Choice.equals("3")) {
                        System.out.println("You have selected THREE!");
                        isSubMenu2Choice = false;

                    }else if(subMenu2Choice.equals("4")) {
                        System.out.println("You have selected FOUR!");
                    }
                    System.out.println("This is the submenu 2");
                }

            } else if (userInput.equalsIgnoreCase("3")) {
                System.out.println("Thank you for visiting CRS!");
                isMenuRunning = false;
            }
        }
    }
}
