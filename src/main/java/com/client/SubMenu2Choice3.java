package com.client;

import com.crs.customer.Customer;
import com.crs.datahub.Invoice;
import com.crs.datahub.InvoiceList;
import com.crs.models.CarCost;

import java.util.stream.Collectors;

public class SubMenu2Choice3 {
    public static void subMenu2Choice3(Customer customer) {
        System.out.println("Your current active invoices");

        var activeReservationList = InvoiceList.getInvoiceList().stream().
                filter(c->c.getCustomer().equals(customer)).collect(Collectors.toList());

        int j=1;

        for(Invoice i/*voice*/ : activeReservationList) {
            System.out.println(j++ +" " + i.getCar().getMake() + " "+ i.getCar().getModel() + " " + i.getCar().getPlateNumber()+
                    " " + i.getReservedPeriods().toString() +
                    "\nCost for this reservation: " +
                    CarCost.totalCharge(i.getCar(), i.getReservedPeriods().getTotalReservedDays()) +
                    "\n"
            );
        }

        SubMenu3.ChangeReservations(activeReservationList, customer);
    }
}

