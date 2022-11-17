package com.crs.datahub;

import com.crs.customer.Customer;
import com.crs.models.CarCost;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.client.GlobalVariable.currentCustomer;

public class InvoiceReservation {
    // creates newFile with invoice.txt

    String userName = currentCustomer.getFirstName() + "_" + currentCustomer.getLastName() + "_";

    // prints out the output file
    PrintWriter writer;
    Date date = new Date();
    // hh for 12hr format, aa for PM/AM
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");

    // creates constructor with try catch and create newFile
    public InvoiceReservation(Reservation reservation) {

        String reservationInfo = reservation.getCar().getYear() + "_"
                + reservation.getCar().getMake() + "_"
                + reservation.getCar().getModel() + "_"
                + reservation.getReservedPeriods().toString() + "_";

        File newFile = new File(userName + reservationInfo + "_Invoice.txt");

        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer = new PrintWriter(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // prints out in output file whenever this method is called in CRSClient
    public void selectCar(Reservation reservation) {
        double charges = CarCost.totalCharge(reservation.getCar(), reservation.getReservedPeriods().getTotalReservedDays());

        writer.println(dateFormat.format(date) + "\n" +
                reservation.getCustomer().getFirstName() + ", " + reservation.getCustomer().getLastName() +
                " has reserved a " + reservation.getCar().getMake() + " "+ reservation.getCar().getModel() +
                "\n" + reservation.getReservedPeriods().toString() +
                "\nTotal Charge is: " +charges +
                "\n");
    }

    public void inventoryPeeked(Customer customer) {
        writer.println(dateFormat.format(date) + " Inventory is seen by " + customer.getFirstName() +" "+ customer.getLastName()+"!");
    }
    // close the audit printer after the program exits
    public void closeFile() {
        writer.close();
    }
}
