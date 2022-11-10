package com.crs.models;

public class Car {

    private String vin;

    private String plateNumber;

    private CarType carType;

    private double price;

    private String year;

    private String make;

    private String model;

    private boolean isReserved;

    public Car() {}

    public Car(String vin) {
        setVin(vin);
    }
    public Car(String vin, String plateNumber, CarType carType, double price, String year, String make, String model) {
        this.vin = vin;
        this.plateNumber = plateNumber;
        this.carType = carType;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public String toString() {

        return null;
    }
}
