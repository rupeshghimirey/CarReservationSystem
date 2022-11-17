package com.client;

import com.crs.datahub.Invoice;
import com.crs.datahub.InvoiceList;
import com.crs.models.CarCost;

import java.util.List;

import static com.client.GlobalVariable.*;

public class SubMenu3 {
    public static void ChangeReservations(List<Invoice> activeReservationList) {
        System.out.println("1. Make Changes to Reservations.\n" +
                "2. Go Back");

        String userInput = userInterface.userInput();

        if (userInput.equals("1")) {
            System.out.println("Select the index of the reservation you want to modify. (Only one reservation can be modified each time.)");

            userInput = userInterface.userInput();

            ModificationMenu(activeReservationList, userInput);
        } else {
            MainMenuOption2.mainMenuOption2();
        }
    }

    public static void ModificationMenu(List<Invoice> activeReservationList, String userInput) {
        try {
            int index = Integer.parseInt(userInput);

            if (index > 0 && index <= activeReservationList.size()) {

                Invoice selectedInvoice = InvoiceList.getInvoiceList().get(index - 1);

                System.out.println("What do you want to modify: \n" +
                        "1. I want to remake the reservation.\n" +
                        "2. I want to cancel this reservation. (can not be reversed!)\n" +
                        "3. My hands were shaking and I clicked the wrong button.\n");

                userInput = userInterface.userInput();

                SelectModification(userInput, selectedInvoice);
            } else {
                System.out.println("Invalid Selection");
                SubMenu3.ChangeReservations(activeReservationList);
            }

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void SelectModification(String userInput, Invoice invoice) {
        if(userInput.equals("1")) {
            //Invoice invoiceTemp = invoice;

            InvoiceList.removeFromInvoiceList(invoice);
            invoice.getCar().getPeriods().remove(invoice.getReservedPeriods());
            invoice.getCustomer().setBalance(invoice.getCustomer().getBalance()
                    + CarCost.totalCharge(invoice.getCar(),invoice.getReservedPeriods().getTotalReservedDays()));

            SubMenu2Choice2.subMenu2Choice2();
        } else if(userInput.equals("2")) {
            cancelReservation(invoice);
        }
        else {
            SubMenu2Choice3.subMenu2Choice3();
        }
    }

    public static void cancelReservation(Invoice invoice) {
        InvoiceList.removeFromInvoiceList(invoice);
        invoice.getCar().getPeriods().remove(invoice.getReservedPeriods());

        invoice.getCustomer().setBalance(invoice.getCustomer().getBalance()
                + CarCost.totalCharge(invoice.getCar(),invoice.getReservedPeriods().getTotalReservedDays()));
    }

}
