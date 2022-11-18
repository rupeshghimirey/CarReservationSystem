package com.crs.datahub;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {

    private static final List<Reservation> reservationList = new ArrayList<>();

    public static List<Reservation> getReservationList() {
        return reservationList;
    }

    public static void addToInvoiceList(Reservation reservation) {
        ReservationList.reservationList.add(reservation);
    }

    public static void removeFromInvoiceList(Reservation reservation) {
        ReservationList.reservationList.remove(reservation);
    }

}
