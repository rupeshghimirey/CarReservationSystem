package com.client;

import com.crs.datahub.Reservation;
import com.crs.datahub.ReservationList;
import com.crs.models.CarCost;

import java.util.List;

import static com.client.GlobalVariable.*;

public class SubMenu3 {
    public static void ChangeReservations(List<Reservation> activeReservationList) {
        System.out.println("(1) Modify Reservations.\n" +
                "(2) Go Back");

        String userInput = userInterface.userInput();

        if (userInput.equals("1")) {
            System.out.println("Select the index of the reservation you want to modify. (Only one reservation can be modified at this time)");

            userInput = userInterface.userInput();

            ModificationMenu(activeReservationList, userInput);
        } else {
            MainMenuOption2.mainMenuOption2();
        }
    }

    public static void ModificationMenu(List<Reservation> activeReservationList, String userInput) {
        try {
            int index = Integer.parseInt(userInput);

            if (index > 0 && index <= activeReservationList.size()) {

                Reservation selectedInvoice = ReservationList.getReservationList().get(index - 1);

                System.out.println("What would you like to modify? \n" +
                        "(1) Modify Reservation\n" +
                        "(2) Cancel Reservation \n" +
                        "(3) My hands were shaking and I clicked the wrong button.\n");

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

    public static void SelectModification(String userInput, Reservation invoice) {
        if(userInput.equals("1")) {

            ReservationList.removeFromInvoiceList(invoice);
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

    public static void cancelReservation(Reservation invoice) {
        ReservationList.removeFromInvoiceList(invoice);
        invoice.getCar().getPeriods().remove(invoice.getReservedPeriods());

        invoice.getCustomer().setBalance(invoice.getCustomer().getBalance()
                + CarCost.totalCharge(invoice.getCar(),invoice.getReservedPeriods().getTotalReservedDays()));
    }

}
