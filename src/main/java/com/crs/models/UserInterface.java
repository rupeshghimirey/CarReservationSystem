package com.crs.models;

import com.crs.datahub.CarInventory;
import com.crs.datahub.ReservedPeriods;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterface {
    private Scanner myScanner;
    CarInventory carInventory = new CarInventory();

    public UserInterface() {
        myScanner = new Scanner(System.in);
        //this.myScanner = myScanner;
    }
    // main menu
    public String printMainMenu() {
        String mainMenuString = "\n***************************************\n" +
                "Welcome to Car Reservation System (CRS)\n" +
                "***************************************\n" +
                "(1) Car Inventory\n"+
                "(2) Reserve Car\n" +
                "(3) Exit\n" +
                "Please enter 1, 2 or 3 only!\n";
        System.out.println(mainMenuString);
        return myScanner.nextLine();
    }

    public void getAllCars() {
        carInventory.getCarCollections().stream().forEach(System.out::println);
    }

    public String printSubMenuOfTwo() {
        String subMenuString = "(1) Balance \n" +
                "(2) Select Car \n" +
                "(3) Option 3 \n" +
                "(4) Option 4 \n" +
                "Please select either 1,2,3 or 4 \n";

        System.out.println(subMenuString);

        String choice = myScanner.nextLine();

        List<String> s = new ArrayList<>();
        for(Integer i = 1; i < 5; i++) {
            s.add(i.toString());
        }

        if(!s.contains(choice)) {
            choice = "-1";
        }

        return choice;
    }
    public String askUserForVinNumber() {
        System.out.println("Please choose the vin number from the list");
        return myScanner.nextLine();
    }

    public List<Car> getAvailableCars(ReservedPeriods reservedPeriods) {
        List<Car> availableCars = carInventory.getCarCollections().stream().filter(
                car -> {
                    boolean flag = true;
                    for(ReservedPeriods d : car.getPeriods()) {
                        boolean statement1 = d.getStartDate().before(reservedPeriods.getStartDate()) && d.getEndDate().after(reservedPeriods.getStartDate());
                        boolean statement2 = d.getStartDate().after(reservedPeriods.getStartDate()) && d.getStartDate().before(reservedPeriods.getEndDate());
                        boolean statement3 = d.getStartDate().equals(reservedPeriods.getStartDate());
                        boolean statement4 = d.getStartDate().equals(reservedPeriods.getEndDate());
                        boolean statement5 = d.getEndDate().equals(reservedPeriods.getStartDate());
                        //boolean statement6 = d.getEndDate().equals(reservedPeriods.getEndDate());
                        if(statement1 || statement2 || statement3 || statement4 || statement5) {
                            flag = false;
                            break;
                        }
                    }
                    return flag;
                }
        ).collect(Collectors.toList());

        return availableCars;
    }

    public String userInput() {
        return myScanner.nextLine();
    }

    public Car selectCar(ReservedPeriods reservedPeriods, String selection) {
        List<Car> availableCars = getAvailableCars(reservedPeriods);

        int selectInt = Integer.parseInt(selection);  //I think this method contains try catch {} module.

        if(selectInt < 0 || selectInt > carInventory.getCarCollections().size()) {
            throw new IllegalArgumentException("Invalid input.");
        }

        Car car = availableCars.get(selectInt - 1);
        car.inputPeriod(reservedPeriods);

        return car;
    }

    public ReservedPeriods inputReservedPeriod(String startDateString, String endDateString) {
        Date startDate;
        Date endDate;

        ReservedPeriods newPeriod = null;

        try {
            startDate = Date.valueOf(startDateString);// need to debug/reformatting
            endDate = Date.valueOf(endDateString);
            if(endDate.before(startDate)) {
                throw new IllegalArgumentException("Invalid input");
            }

            newPeriod = new ReservedPeriods(startDate, endDate);

        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return newPeriod;
    }
}
