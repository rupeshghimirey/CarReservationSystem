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

        UserInterface userInterface = new UserInterface();
        String userInput = userInterface.printMainMenu();

        if(userInput.equalsIgnoreCase("1")) {
            userInterface.getAllCars();
        } else if(userInput.equalsIgnoreCase("2")) {
            userInterface.printSubMenuOfTwo();
            System.out.println("This is the submenu 2");
        }
    }
}
