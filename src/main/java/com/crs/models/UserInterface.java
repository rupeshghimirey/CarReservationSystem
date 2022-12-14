package com.crs.models;

import com.crs.datahub.CarInventory;
import com.crs.datahub.ReservedPeriods;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.client.GlobalVariable.currentCustomer;

public class UserInterface {
    private Scanner myScanner;
    CarInventory carInventory = new CarInventory();

    public UserInterface() throws FileNotFoundException {
        myScanner = new Scanner(System.in);
    }

    private String drawTitle() {
        String title;

        int userNameLength = currentCustomer.getFirstName().length();

        String drawStar = "";
        String welcomeString = "Welcome to Car Reservation System (CRS), ";

        for (int i = 0; i < userNameLength + welcomeString.length(); i++) {
            drawStar += "*";
        }

        title = "\n" + drawStar + "\n" + welcomeString + currentCustomer.getFirstName() + "\n" +
                drawStar + "\n";

        return title;
    }

    //This is the Main Menu.
    public String printMainMenu() {
        String mainMenuString = drawTitle() +
                "(1) Display Car Inventory\n" +
                "(2) Switch Users\n" +
                "(3) Make Reservation\n" +
                "(4) Exit\n" +
                "Please enter 1, 2, 3 or 4 only!\n";
        System.out.println(mainMenuString);
        return myScanner.nextLine();
    }

    public void getAllCars() {
        CarCost.costInitialization();
        carInventory.getCarCollections().stream().forEach(c -> c.setPricePerDay(CarCost.costChart.get(c.getCarType())));
        carInventory.getCarCollections().stream().forEach(System.out::println);
    }

    public String printSubMenuTwo() {
        String subMenuString = "(1) View/Add Balance\n" +
                "(2) Reserve a Car\n" +
                "(3) " + currentCustomer.getFirstName() + "'s Reservations\n" +
                "(4) Back to Main Menu\n" +
                "Please select either 1,2,3 or 4!\n";

        System.out.println(subMenuString);

        String choice = myScanner.nextLine();

        return choice;
    }

    public List<Car> getAvailableCars(ReservedPeriods reservedPeriods) {
        List<Car> availableCars = carInventory.getCarCollections().stream().filter(
                car -> {
                    boolean flag = true;
                    for (ReservedPeriods d : car.getPeriods()) {
                        boolean statement1 = d.getStartDate().before(reservedPeriods.getStartDate())
                                && d.getEndDate().after(reservedPeriods.getStartDate());

                        boolean statement2 = d.getStartDate().after(reservedPeriods.getStartDate())
                                && d.getStartDate().before(reservedPeriods.getEndDate());

                        //in case dates collision happened
                        boolean statement3 = d.getStartDate().equals(reservedPeriods.getStartDate());
                        boolean statement4 = d.getStartDate().equals(reservedPeriods.getEndDate());
                        boolean statement5 = d.getEndDate().equals(reservedPeriods.getStartDate());

                        if (statement1 || statement2 || statement3 || statement4 || statement5) {
                            flag = false;
                            break;
                        }
                    }
                    return flag;
                }
        ).collect(Collectors.toList());

        CarCost.costInitialization();
        carInventory.getCarCollections().stream().forEach(c ->
                c.setPricePerDay(CarCost.costChart.get(c.getCarType())
                ));

        return availableCars;
    }

    public String userInput() {
        return myScanner.nextLine();
    }

    public Car selectCar(ReservedPeriods reservedPeriods, String selection) {
        List<Car> availableCars = getAvailableCars(reservedPeriods);

        Car car = new Car();

        try {
            int selectInt = Integer.parseInt(selection);
            if (selectInt < 1 || selectInt > carInventory.getCarCollections().size()) {
                System.out.println("Invalid Input, Selection Out of Range!");
            } else {
                car = availableCars.get(selectInt - 1);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return car;
    }

    public ReservedPeriods inputReservedPeriod(String startDateString, String endDateString) {
        Date startDate;
        Date endDate;

        ReservedPeriods newPeriod = new ReservedPeriods(Date.valueOf("0001-01-01"), Date.valueOf("9999-12-31"));

        try {
            startDate = Date.valueOf(startDateString);
            endDate = Date.valueOf(endDateString);
            if (endDate.before(startDate)) {
                System.out.println("Invalid Dates!");
            }

            newPeriod = new ReservedPeriods(startDate, endDate);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return newPeriod;
    }

    public void thankYouMessage() {
        System.out.println("Thank You for visiting CRS! See you again!");

    }
}
