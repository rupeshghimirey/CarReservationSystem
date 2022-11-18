package com.client;

import com.crs.datahub.Reservation;
import com.crs.datahub.ReservationList;
import com.crs.datahub.ReservedPeriods;
import com.crs.models.Car;
import com.crs.models.CarCost;
import static com.client.GlobalVariable.*;

public class SubMenu2Choice2 {
    public static void subMenu2Choice2() {
        System.out.println("Please input the starting date:(Date format yyyy-mm-dd)");
        String startDate = userInterface.userInput();
        System.out.println("Please input the end date(Date format yyyy-mm-dd)");
        String endDate = userInterface.userInput();

        ReservedPeriods newPeriod1 = userInterface.inputReservedPeriod(startDate, endDate);
        System.out.printf("%-10s %-15s %-15s %-14s %-13s %-12s %-11s %-11s",
                "Car Index", "Vin Number", "Plate Number", "Car Type", "Price/Day", "Year", "Make", "Model");
        System.out.println();
        System.out.println();
        int i = 0;
        for (Car c : userInterface.getAvailableCars(newPeriod1)) {
            System.out.println(++i + " " + c.toString());
        }

        boolean flag = true;
        String selectedCarIndex;
        do {
            System.out.println("Please select the car index to reserve");
            selectedCarIndex = userInterface.userInput();
            try {
                int j = Integer.parseInt(selectedCarIndex);
                if (j > 0 && j <= i) {
                    flag = false;
                } else {
                    System.out.println("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (flag);

        Car c = userInterface.selectCar(newPeriod1, selectedCarIndex);

        double charges = CarCost.totalCharge(c, newPeriod1.getTotalReservedDays());

        if (charges > currentCustomer.getBalance()) {

            System.out.println("Not enough balance on " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + " account!");

            SubMenu2Choice1.subMenu2Choice1();
            return;

        } else {
            c.inputPeriod(newPeriod1);

            Reservation newInvoice = new Reservation(currentCustomer,newPeriod1,c);
            ReservationList.addToInvoiceList(newInvoice);

            System.out.println(c.getVin() + " " + c.getMake() + " " + c.getModel() + " " + "is successfully reserved!");

            currentCustomer.setBalance(currentCustomer.getBalance() - charges);
            System.out.println(currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + " is charged with: $" + charges);
            System.out.println("Current balance: $" + currentCustomer.getBalance());
        }
    }
}
