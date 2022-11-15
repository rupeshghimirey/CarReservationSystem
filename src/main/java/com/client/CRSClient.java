package com.client;

import com.crs.customer.Address;
import com.crs.customer.CreditCard;
import com.crs.customer.Customer;
import com.crs.datahub.CarInventory;
import com.crs.datahub.ReservedPeriods;
import com.crs.models.Car;
import com.crs.models.UserInterface;
import java.io.FileNotFoundException;



public class CRSClient {
    private UserInterface userInterface;
//    private CarInventory carInventory;

    public CRSClient(UserInterface userInterface, CarInventory carInventory) throws FileNotFoundException {
        this.userInterface = userInterface;
//        this.carInventory = carInventory;

    }

    public static void main(String[] args) throws FileNotFoundException {
        CarInventory carInventory = new CarInventory();

        boolean isMenuRunning = true;
        UserInterface userInterface = new UserInterface();
        Customer customer1 = new Customer("1", "Rupesh", "123-456-7891",
                new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
                new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {
            @Override
            public void pay() {
                System.out.println("CC");
            }
        });

        while (isMenuRunning) {
            String userInput = userInterface.printMainMenu();

            if (userInput.equalsIgnoreCase("1")) {
                userInterface.getAllCars();
            } else if (userInput.equalsIgnoreCase("2")) {
                boolean isSubMenu2Choice = true;
                String subMenu2Choice = userInterface.printSubMenuOfTwo();
                while (isSubMenu2Choice) {
                    if (subMenu2Choice.equals("1")) {
                        System.out.println("Your current Balance is: " + customer1.getBalance());
                        System.out.println("(1) Add more Balance");
                        System.out.println("(2) Previous Menu");
                        isSubMenu2Choice = false;
                    } else if (subMenu2Choice.equals("2")) {
                        System.out.println("Please input the starting date");
                        String startDate = userInterface.userInput();
                        System.out.println("Please input the end date");
                        String endDate = userInterface.userInput();

                        ReservedPeriods newPeriod1 = userInterface.inputReservedPeriod(startDate, endDate);
                        int i = 0;
                        for(Car c : userInterface.getAvailableCars(newPeriod1)) {
                            System.out.println(++i + " " + c.toString());
                        }

                        boolean flag = true;
                        String selectedCarIndex;
                        do {
                            System.out.println("Please select the car index to reserve");
                            selectedCarIndex = userInterface.userInput();
                            try {
                                int j = Integer.parseInt(selectedCarIndex);
                                if(j > 0 && j <= i) {
                                    flag = false;
                                } else {
                                    System.out.println("Invalid input!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        while(flag);

                        if(carInventory.getCarCollections().size() >= Integer.parseInt(selectedCarIndex)) {
                            Car c = userInterface.selectCar(newPeriod1, selectedCarIndex);
                            System.out.println(c.getVin() + " " +c.getMake() + " "+ c.getModel() + " " + "Successfully Reserved!");
                        } else {
                            System.out.println("Please type the valid car index!");

                        }
                        isSubMenu2Choice = false;

                    } else if (subMenu2Choice.equals("3")) {
                        System.out.println("You have selected THREE!");
                        isSubMenu2Choice = false;

                    } else if (subMenu2Choice.equals("4")) {
                        System.out.println("You have selected FOUR!");
                    }
                }

            } else if (userInput.equalsIgnoreCase("3")) {
                System.out.println("Thank you for visiting CRS!");
                isMenuRunning = false;
            }
        }
    }
}
