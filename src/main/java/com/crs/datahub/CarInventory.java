package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class CarInventory implements ICarInventory {

    CarFileReader reader = new CarFileReader();

    private List<Car> carCollections = new ArrayList<>();

    public CarInventory() throws FileNotFoundException {
        carCollections = reader.processCarInventory();
    }

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
        car.setReserved(true);
        carMap.put(vin, car);
        System.out.println(carMap);
        return carMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarInventory that = (CarInventory) o;

        if (reader != null ? !reader.equals(that.reader) : that.reader != null) return false;
        return carCollections != null ? carCollections.equals(that.carCollections) : that.carCollections == null;
    }

    @Override
    public int hashCode() {
        int result = reader != null ? reader.hashCode() : 0;
        result = 31 * result + (carCollections != null ? carCollections.hashCode() : 0);
        return result;
    }
}
