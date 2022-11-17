package com.crs.models;

import com.crs.datahub.CarFileReader;
import com.crs.datahub.ReservedPeriods;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {

    private UserInterface userInterface;
    private List<Car> expectedCarCollections;
    private ReservedPeriods reservedPeriods;

    @Before
    public void setUp() throws Exception {
        userInterface = new UserInterface();

        CarFileReader carFileReader = new CarFileReader();
        expectedCarCollections = new ArrayList<>();
        expectedCarCollections = carFileReader.processCarInventory();

        Date startDate = Date.valueOf("2022-11-01");
        Date endDate = Date.valueOf("2022-11-15");
        reservedPeriods = new ReservedPeriods(startDate, endDate);
    }

    @Test
    public void testGetAllCars_sout_car_inventory() {
        userInterface.getAllCars();
    }

    @Test
    public void testGetAvailableCars_show_available_car_for_dates_selected() {

        List<Car> availableCars = userInterface.getAvailableCars(reservedPeriods);
        assertEquals(expectedCarCollections, availableCars);
    }


    @Test
    public void testSelectCar_user_selects_available_car() {
        Car expectedCar = new Car("10001", "WA 45896", CarType.SEDAN,
                "2022", "Toyota", 100.0, "Camry");
        Car actualCar = userInterface.selectCar(reservedPeriods, "1");
        assertEquals(expectedCar, actualCar);

    }

    @Test
    public void testInputReservedPeriod_user_inputs_string_dates() {
        ReservedPeriods actualReservedPeriod = userInterface.inputReservedPeriod("2022-11-01", "2022-11-15");
        assertEquals(reservedPeriods, actualReservedPeriod);
    }

    @Test
    public void _inputReservedPeriod_user_inputs_start_date_after_end_date() {
        try {
            ReservedPeriods invalidReservedPeriods = userInterface.inputReservedPeriod("2022-11-30", "2022-11-01");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }

    }
}