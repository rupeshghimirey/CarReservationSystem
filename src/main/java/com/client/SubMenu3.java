package com.client;

import com.crs.datahub.InvoiceReservation;
import com.crs.datahub.Reservation;
import com.crs.datahub.ReservationList;
import com.crs.exceptions.InvalidArgumentExceptions;
import com.crs.models.CarCost;

import java.util.List;

import static com.client.GlobalVariable.invoiceReservation;
import static com.client.GlobalVariable.userInterface;

public class SubMenu3 {
    public static void ChangeReservations(List<Reservation> activeReservationList) {
        System.out.println("1. Make Changes to Reservations.\n" +
                "2. Print Selected Invoices. (Only One Each Time)\n" + //because of the awkward input system of console app.
                "3. Go Back");

        String userInput = userInterface.userInput();

        if (userInput.equals("1")) {
            System.out.println("Select the index of the reservation you want to modify. (Only one reservation can be modified each time.)");

            userInput = userInterface.userInput();

            ModificationMenu(activeReservationList, userInput);
        } else if (userInput.equals("2")) {

            System.out.println("Select the index of the reservation you want to print.");

            userInput = userInterface.userInput();

            printInvoices(activeReservationList, userInput);
        }
    }

    public static Reservation selectedReservation(List<Reservation> activeReservationList, String userInput) {
        Reservation selectedInvoice = null;

        try {
            int index = Integer.parseInt(userInput);

            if (index > 0 && index <= activeReservationList.size()) {
                selectedInvoice = ReservationList.getReservationList().get(index - 1);
            } else {
                System.out.println("Selection Out of Range!");
            }
        } catch (InvalidArgumentExceptions e) {
            System.out.println("Error: " + e);
        }

        return selectedInvoice;
    }

    public static void ModificationMenu(List<Reservation> activeReservationList, String userInput) {

        Reservation selectedInvoice = selectedReservation(activeReservationList, userInput);

        if (selectedInvoice != null) {
            System.out.println("What Would You Like to Modify:\n" +
                    "1. I want to remake the reservation.\n" +
                    "2. I want to cancel this reservation. (can not be reversed!)\n" +
                    "3. My hands were shaking and I clicked the wrong button.\n");

            userInput = userInterface.userInput();

            SelectModification(userInput, selectedInvoice);
        } else {

            SubMenu3.ChangeReservations(activeReservationList);
        }
    }

    public static void SelectModification(String userInput, Reservation reservation) {
        if (userInput.equals("1")) {

            ReservationList.removeFromInvoiceList(reservation);
            reservation.getCar().getPeriods().remove(reservation.getReservedPeriods());
            reservation.getCustomer().setBalance(reservation.getCustomer().getBalance()
                    + CarCost.totalCharge(reservation.getCar(), reservation.getReservedPeriods().getTotalReservedDays()));

            SubMenu2Choice2.subMenu2Choice2();

        } else if (userInput.equals("2")) {
            cancelReservation(reservation);
        }
    }

    public static void printInvoices(List<Reservation> activeReservationList, String userInput) {
        Reservation selectedInvoice = selectedReservation(activeReservationList, userInput);

        if (selectedInvoice != null) {
            try {
                invoiceReservation = new InvoiceReservation(selectedInvoice);

                invoiceReservation.selectCar(selectedInvoice);

                invoiceReservation.closeFile();

                System.out.println("Selected Invoice Printed Successfully.");
                System.out.println("Press Any Key to Continue.");

                userInterface.userInput();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid Operation, Cannot Print!");
        }
    }

    public static void cancelReservation(Reservation invoice) {
        ReservationList.removeFromInvoiceList(invoice);

        invoice.getCar().getPeriods().remove(invoice.getReservedPeriods());

        invoice.getCustomer().setBalance(invoice.getCustomer().getBalance()
                + CarCost.totalCharge(invoice.getCar(), invoice.getReservedPeriods().getTotalReservedDays()));

        System.out.println("Reservation Cancelled");
    }
}
