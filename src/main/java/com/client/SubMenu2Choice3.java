package com.client;

import com.crs.datahub.Invoice;
import com.crs.datahub.InvoiceList;
import com.crs.models.CarCost;

import java.util.stream.Collectors;

import static com.client.GlobalVariable.currentCustomer;
import static com.client.GlobalVariable.userInterface;

public class SubMenu2Choice3 {
    public static void subMenu2Choice3() {
        System.out.println("Your current active invoices");

        var activeReservationList = InvoiceList.getInvoiceList().stream().
                filter(c->c.getCustomer().equals(currentCustomer)).collect(Collectors.toList());

        int j=1;

        int activeReservationListSize = activeReservationList.size();

        if(activeReservationListSize > 0) {
            for(Invoice i/*voice*/ : activeReservationList) {
                System.out.println(j++ +" " + i.getCar().getMake() + " "+ i.getCar().getModel() + " " + i.getCar().getPlateNumber()+
                        " " + i.getReservedPeriods().toString() +
                        "\nCost for this reservation: " +
                        CarCost.totalCharge(i.getCar(), i.getReservedPeriods().getTotalReservedDays()) +
                        "\n"
                );
            }

            SubMenu3.ChangeReservations(activeReservationList);

        } else {
            System.out.println("You don't have any active reservations, press any key to go back to previous menu.");
        }

        userInterface.userInput();
    }
}

