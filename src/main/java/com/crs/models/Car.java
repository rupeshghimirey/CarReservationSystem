package com.crs.models;

import com.crs.datahub.ReservedPeriods;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    private String vin;
    private String plateNumber;
    private CarType carType;
    private String year;
    private String make;
    private String model;
    private double pricePerDay;
    private boolean isReserved;

    private final List<ReservedPeriods> periods = new ArrayList<>();

    public Car() {}

    public Car(String vin) {
        setVin(vin);
    }

    public Car(String vin, String plateNumber, CarType carType,  String year, String make, double pricePerDay, String model) {
        this.vin = vin;
        this.plateNumber = plateNumber;
        this.carType = carType;
        this.pricePerDay = pricePerDay;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {

        this.pricePerDay = pricePerDay;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public List<ReservedPeriods> getPeriods() {
        return periods;
    }

    public void inputPeriod(ReservedPeriods period) {
        if(period == null || period.getStartDate().after(period.getEndDate())) {
            System.out.println("Invalid Input!");
            //throw new IllegalArgumentException("NUll DATES");
            return;
        }
        periods.add(period);
    }

    @Override
    public String toString() {
        String result = String.format("%-10s %-15s %-15s %-14s %-13s %-12s %-11s %-11s","",
                getVin(),getPlateNumber() ,getCarType(),getPricePerDay(),getYear(),getMake(),getModel());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.pricePerDay, pricePerDay) != 0) return false;
        if (isReserved != car.isReserved) return false;
        if (!Objects.equals(vin, car.vin)) return false;
        if (!Objects.equals(plateNumber, car.plateNumber)) return false;
        if (carType != car.carType) return false;
        if (!Objects.equals(year, car.year)) return false;
        if (!Objects.equals(make, car.make)) return false;
        if (!Objects.equals(model, car.model)) return false;
        return Objects.equals(periods, car.periods);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vin != null ? vin.hashCode() : 0;
        result = 31 * result + (plateNumber != null ? plateNumber.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(pricePerDay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isReserved ? 1 : 0);
        result = 31 * result + (periods != null ? periods.hashCode() : 0);
        return result;
    }
}
