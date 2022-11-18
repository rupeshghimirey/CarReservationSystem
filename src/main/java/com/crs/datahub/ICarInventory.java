package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.util.List;
import java.util.Map;

public interface ICarInventory {
    Car findByVin(String vin);

    List<Car> findByCarType(CarType carType);

    List<Car> findAvailableCar(CarType carType);

    List<Car> findReservedCar(CarType carType);

    Map<String, Car> reserveCar(String vin);
}
