package com.crs.models;

import com.crs.datahub.ReservedPeriods;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String vin;
    private String plateNumber;
    private CarType carType;
    private String year;
    private String make;
    private String model;
    private double pricePerDay;
    private boolean isReserved;

    private List<ReservedPeriods> periods = new ArrayList<>();

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
        if(period == null) {
            throw new IllegalArgumentException("NUll DATES");
        }
        if(period.getStartDate().after(period.getEndDate())) {
            System.out.println("invalid input.");
            return;
        }
        periods.add(period);
    }

    public void updatePeriod(ReservedPeriods period) {
    }

    public void removePeriod(ReservedPeriods period) {

    }

    public static Car newInstance(String vin, String plateNumber, CarType carType, double price, String year, String make, String model) {
        Car car = new Car(vin, plateNumber, carType, year, make,price, model);
        return car;
    }

    @Override
    public String toString() {

        String result = String.format("%-10s %-15s %-15s %-14s %-13s %-12s %-11s %-11s","",
                getVin(),getPlateNumber() ,getCarType(),getPricePerDay(),getYear(),getMake(),getModel());
        return result;
    }
}
