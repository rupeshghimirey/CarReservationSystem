package com.crs.models;

import com.crs.datahub.CarInventory;
import com.crs.datahub.ReservedPeriods;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class CarCostTest {

    private CarCost carCost;

    @Before
    public void setUp() throws Exception {
        carCost = new CarCost();

    }

    @Test
    public void totalCharge() {
        long days = 5;
        Car car = new Car("10001", "WA 45896", CarType.SEDAN,
                "2022", "Toyota", 100.0, "Camry");
        double actualTotal = carCost.totalCharge(car, days);

        double expectedTotal = 500.0;


        assertEquals(expectedTotal, actualTotal, .001);

    }
}