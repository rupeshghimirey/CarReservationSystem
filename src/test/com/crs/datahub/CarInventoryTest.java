package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CarInventoryTest {

    private List<Car> carCollections;
    private CarInventory carInventory;

    @Before
    public void setUp() throws Exception {
        CarFileReader carFileReader = new CarFileReader();
        carCollections = new ArrayList<>();
        carCollections = carFileReader.processCarInventory();
        carInventory = new CarInventory();
    }

    @Test
    public void getCarCollections() {
        List<Car> actualCarCollections = carInventory.getCarCollections();
        assertEquals(carCollections, actualCarCollections);
        System.out.println(carCollections);

    }

    @Test
    public void findByVin() {
        Car actualByVin = carInventory.findByVin("10004");
        Car expectedCar = new Car("10004", "WA 78965", CarType.LUXURY,
                "2020", "BMW", 400.0, "X7");
        assertEquals(expectedCar, actualByVin);
    }

    @Test
    public void findByCarType() {
        List<Car> actualByCarType = carInventory.findByCarType(CarType.SEDAN);
        ArrayList<Car> expectedCars = new ArrayList<>(List.of(new Car("10001", "WA 45896", CarType.SEDAN,
                "2022", "Toyota", 100.0, "Camry"),
                new Car("10007", "WA 74123", CarType.SEDAN,
                        "2012", "Audi", 100.0, "A3"),
                new Car("10009", "NC 12345", CarType.SEDAN,
                        "2022", "Audi", 100.0, "A3"),
                new Car("10013", "NY 45678", CarType.SEDAN,
                        "2018", "Toyota", 100.0, "Corolla"),
                new Car("10015", "CT 32547", CarType.SEDAN,
                        "2015", "Audi", 100.0, "A3"),
                new Car("10017", "MA 36541", CarType.SEDAN,
                        "2014", "Audi", 100.0, "A3"),
                new Car("10023", "ND 35789", CarType.SEDAN,
                        "2010", "Audi", 100.0, "A3")));
        assertEquals(expectedCars, actualByCarType);
    }

    @Test
    public void findAvailableCar() {
        List<Car> availableCarByType = carInventory.findAvailableCar(CarType.JEEP);
        assertEquals(carCollections, availableCarByType);

    }

    @Test
    public void findReservedCar() {
        List<Car> reservedCar = carInventory.findReservedCar(CarType.LUXURY);
        ArrayList<Car> cars = new ArrayList<>();
        assertEquals(cars, reservedCar);

    }

    @Test
    public void reserveCar() {
        Map<String, Car> actualCarMap = carInventory.reserveCar("10023");
        HashMap<String, Car> expectedHashMap = new HashMap<>();
        expectedHashMap.put("10023", new Car("10023", "ND 35789", CarType.SEDAN,
                "2010", "Audi", 100.0, "A3" ));
        assertEquals(expectedHashMap, actualCarMap);
    }
}