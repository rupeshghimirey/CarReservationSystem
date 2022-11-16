package com.client;

import com.crs.customer.Customer;
import com.crs.datahub.Invoice;
import com.crs.datahub.InvoiceList;
import com.crs.datahub.ReservedPeriods;
import com.crs.models.Car;
import com.crs.models.CarCost;

public class SubMenu2Choice2 {
    public static void subMenu2Choice2(Customer customer) {
        System.out.println("Please input the starting date");
        String startDate = GlobalVariable.userInterface.userInput();
        System.out.println("Please input the end date");
        String endDate = GlobalVariable.userInterface.userInput();

        ReservedPeriods newPeriod1 = GlobalVariable.userInterface.inputReservedPeriod(startDate, endDate);
        System.out.printf("%-10s %-15s %-15s %-14s %-13s %-12s %-11s %-11s",
                "Car Index", "Vin Number", "Plate Number", "Car Type", "Price/Day", "Year", "Make", "Model");
        System.out.println();
        System.out.println();
        int i = 0;
        for (Car c : GlobalVariable.userInterface.getAvailableCars(newPeriod1)) {
            System.out.println(++i + " " + c.toString());
        }

        boolean flag = true;
        String selectedCarIndex;
        do {
            System.out.println("Please select the car index to reserve");
            selectedCarIndex = GlobalVariable.userInterface.userInput();
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

        Car c = GlobalVariable.userInterface.selectCar(newPeriod1, selectedCarIndex);

        double charges = CarCost.totalCharge(c, newPeriod1.getTotalReservedDays());

        if (charges > customer.getBalance()) {

            System.out.println("Not enough balance on " + customer.getFirstName() + " " + customer.getLastName() + " account!");

            SubMenu2Choice1.subMenu2Choice1(customer);

        } else {
            c.inputPeriod(newPeriod1);

            Invoice newInvoice = new Invoice(customer,newPeriod1,c);
            InvoiceList.addToInvoiceList(newInvoice);

            GlobalVariable.invoiceReservation.selectCar(newInvoice);

            System.out.println(c.getVin() + " " + c.getMake() + " " + c.getModel() + " " + "is successfully reserved!");

            GlobalVariable.invoiceReservation.closeFile();

            customer.setBalance(customer.getBalance() - charges);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " is charged with: $" + charges);
            System.out.println("Current balance: $" + customer.getBalance());
        }
    }
}
