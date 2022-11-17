package com.crs.datahub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class ReservedPeriodsTest {

    private ReservedPeriods reservedPeriods;

    @Before
    public void setUp() throws Exception {
        Date startDate = Date.valueOf("2022-11-01");
        Date endDate = Date.valueOf("2022-11-15");
        reservedPeriods = new ReservedPeriods(startDate, endDate);

    }

    @Test
    public void getTotalReservedDays() {
        long expected = 15;
        long totalReservedDays = reservedPeriods.getTotalReservedDays();
        Assert.assertEquals(expected, totalReservedDays);


    }
}