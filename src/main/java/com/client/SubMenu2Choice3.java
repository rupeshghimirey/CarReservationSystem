package com.client;

import com.crs.datahub.Reservation;
import com.crs.datahub.ReservationList;
import com.crs.models.CarCost;

import java.util.stream.Collectors;

import static com.client.GlobalVariable.currentCustomer;
import static com.client.GlobalVariable.userInterface;

public class SubMenu2Choice3 {
    public static void subMenu2Choice3() {
        System.out.println("Current Active reservations for " + currentCustomer.getFirstName() + ":");

        var activeReservationList = ReservationList.getReservationList().stream().
                filter(c->c.getCustomer().equals(currentCustomer)).collect(Collectors.toList());

        int j=1;

        int activeReservationListSize = activeReservationList.size();

        if(activeReservationListSize > 0) {
            for(Reservation i/*voice*/ : activeReservationList) {
                System.out.println(j++ +" " + i.getCar().getMake() + " "+ i.getCar().getModel() + " " + i.getCar().getPlateNumber()+
                        " " + i.getReservedPeriods().toString() +
                        "\nCost for this reservation: " +
                        CarCost.totalCharge(i.getCar(), i.getReservedPeriods().getTotalReservedDays()) +
                        "\n"
                );
            }
            SubMenu3.ChangeReservations(activeReservationList);

        } else {
            System.out.println("No Active Reservations. Press Any Key to Continue.");
        }

        userInterface.userInput();
    }
}

