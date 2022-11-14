package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.util.List;
import java.util.Map;

public interface ICarInventory {
    public Car findByVin(String vin);

    public List<Car> findByCarType(CarType carType);

    public List<Car> findAvailableCar(CarType carType);

    public List<Car> findReservedCar(CarType carType);

    public Map<String, Car> reserveCar(String vin);


}
