package com.client;

import com.crs.datahub.ReservedPeriods;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Date date1 = Date.valueOf("2022-11-05");
        Date date2 = Date.valueOf("2022-11-08");

        var localDate1 = date1.toLocalDate();
        var localDate2 = date2.toLocalDate();

        var diff = localDate1.datesUntil(localDate2).count();
        diff += 1;
        System.out.println(diff);
    }
}
