package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.util.*;

public class CarInventory {

    //carInventory key should be car vin number? value should be car object;

    private List<Car> carCollections = new ArrayList<>(
            List.of(
                    new Car("vin1", "WA98032", CarType.LUXURY,  "2016", "Audi",400.00, "A3"),
                    new Car("vin2", "WA98342", CarType.JEEP,  "2017", "Ford",200.00, "JEEP"),
                    new Car("vin3", "WA91232", CarType.SEDAN,  "2018", "Honda",100.00, "Civic"),
                    new Car("vin4", "WA98462", CarType.SPORTS,  "2019", "Mitsubishi", 300.00,"GTR")
            )
    );

    public List<Car> getCarCollections() {
        return carCollections;
    }

    public void setCarCollections(List<Car> carCollections) {
        this.carCollections = carCollections;
    }

}
