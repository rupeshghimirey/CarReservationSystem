package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.io.FileNotFoundException;
import java.util.*;

public class CarInventory {

    private static int initialQuantity = 5;
    private Map<String,Car> myMap = new TreeMap<>();

    public Map<String, Car> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, Car> myMap) {
        this.myMap = myMap;
    }

    CarFileReader reader = new CarFileReader();

    public CarInventory() throws FileNotFoundException {
        myMap = reader.loadCarInventory(initialQuantity);
    }

    private List<Car> carCollections = new ArrayList<>(
            List.of(
                    new Car("vin1", "WA98032", CarType.LUXURY,  "2016", "Audi",400.00, "A3"),
                    new Car("vin2", "WA98342", CarType.JEEP,  "2017", "Ford",200.00, "JEEP"),
                    new Car("vin3", "WA91232", CarType.SEDAN,  "2018", "Honda",100.00, "Civic"),
                    new Car("vin4", "WA98462", CarType.SPORTS,  "2019", "Mitsubishi", 300.00,"GTR")
            )
    );

    public Map<String,Car> getCarCollections() {
        return myMap;
    }

    public void setCarCollections(List<Car> carCollections) {
        this.carCollections = carCollections;
    }

}
