package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.util.*;

public class CarInventory {

    //carInventory key should be car vin number? value should be car object;

    private List<Car> carCollections = new ArrayList<>(
            List.of(
                    new Car("vin1", "WA98032", CarType.LUXURY, 109000.0, "2016", "Audi", "A3"),
                    new Car("vin2", "WA98342", CarType.JEEP, 49000.0, "2017", "Ford", "JEEP"),
                    new Car("vin3", "WA91232", CarType.SEDAN, 29000.0, "2018", "Honda", "Civic"),
                    new Car("vin4", "WA98462", CarType.SPORTS, 109000.0, "2019", "Mitsubishi", "GTR")
            )
    );

    public List<Car> getCarCollections() {
        return carCollections;
    }

    public void setCarCollections(List<Car> carCollections) {
        this.carCollections = carCollections;
    }



//    CarInventory carInventory = new CarInventory();
//            for(Car car: carInventory.getCarCollections()) {
//        System.out.println(car);
//    }
}
