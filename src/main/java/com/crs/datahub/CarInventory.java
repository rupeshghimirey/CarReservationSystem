package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarInventory implements ICarInventory {

    //carInventory key should be car vin number? value should be car object;

    private List<Car> carCollections = new ArrayList<>(
            List.of(
                    new Car("vin1", "WA98032", CarType.LUXURY,  "2020", "Audi",400.00, "A3"),
                    new Car("vin2", "WA98032", CarType.LUXURY,  "2020", "Mercedes",400.00, "A3"),
                    new Car("vin3", "WA98032", CarType.LUXURY,  "2020", "Cadaillac",400.00, "A3"),
                    new Car("vin4", "WA98032", CarType.SPORTS,  "2020", "Porsche",300.00, "911"),
                    new Car("vin5", "WA98462", CarType.SPORTS,  "2019", "Mitsubishi", 300.00,"GTR"),
                    new Car("vin6", "WA98462", CarType.SPORTS,  "2019", "Chevrolet", 300.00,"Corvette"),
                    new Car("vin7", "WA98342", CarType.JEEP,  "2017", "Jeep",200.00, "Wrangler"),
                    new Car("vin8", "WA98342", CarType.JEEP,  "2017", "Jeep",200.00, "Wrangler"),
                    new Car("vin9", "WA98342", CarType.JEEP,  "2017", "Jeep",200.00, "Wrangler"),
                    new Car("vin10", "WA91232", CarType.SEDAN,  "2018", "Honda",100.00, "Civic"),
                    new Car("vin11", "WA98462", CarType.SPORTS,  "2019", "Mitsubishi", 300.00,"GTR")
            )
    );

    public List<Car> getCarCollections() {
        return carCollections;
    }

    public void setCarCollections(List<Car> carCollections) {
        this.carCollections = carCollections;
    }

    @Override
    public Car findByVin(String vin) {
        Car result = null;
        List<Car> carStream = carCollections.stream()
                .filter(car -> car.getVin().equals(vin))
                .collect(Collectors.toList());

        if (carStream.size() == 1){
            result = carStream.get(0);
        }
        return result;
    }

    @Override
    public List<Car> findByCarType(CarType carType) {
        List<Car> carStream = carCollections.stream()
                .filter(car -> car.getCarType() == carType)
                .collect(Collectors.toList());
        return carStream;
    }

    @Override
    public List<Car> findAvailableCar(CarType carType) {
        List<Car> carStream = carCollections.stream()
                .filter(car -> !car.isReserved())
                .collect(Collectors.toList());
        return carStream;
    }

    @Override
    public List<Car> findReservedCar(CarType carType) {
        List<Car> carStream = carCollections.stream()
                .filter(car -> car.isReserved())
                .collect(Collectors.toList());
        return carStream;
    }

    @Override
    public Map<String, Car> reserveCar(String vin) {
        Map<String, Car> carMap = new HashMap<>();
        Car car = findByVin(vin);
        carMap.put(vin, car);
//        Map<String, Car> carMap = carCollections.stream()
//                .collect(Collectors.toMap())
        return carMap;
    }
}
