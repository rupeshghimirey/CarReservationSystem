package com.client;

import com.crs.datahub.CarInventory;
import com.crs.models.Car;
import com.crs.models.CarType;
import com.crs.models.UserInterface;

import java.io.FileNotFoundException;
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

    public static void main(String[] args) throws FileNotFoundException {

        UserInterface userInterface = new UserInterface();

        String userInput = userInterface.printMainMenu();

        if(userInput.equalsIgnoreCase("1")) {
            CarInventory carInventory = new CarInventory();
            for(Car car: carInventory.getCarCollections().values()) {
                System.out.println(car);
            }
        }
    }
}
