package com.crs.models;

public class Car {

    private String vin;
    private String plateNumber;
    private CarType carType;
    private String year;
    private String make;
    private String model;
    private double pricePerDay;
    private boolean isReserved;
    private int initialQuantity;


    public Car() {}

    public Car(String vin) {
        setVin(vin);
    }

    public Car(String vin, String plateNumber, CarType carType,  String year, String make, double pricePerDay, String model, int initialQuantity) {
        this.vin = vin;
        this.plateNumber = plateNumber;
        this.carType = carType;
        this.pricePerDay = pricePerDay;
        this.year = year;
        this.make = make;
        this.model = model;
        this.initialQuantity = initialQuantity;
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

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
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

    public static Car newInstance(String vin, String plateNumber, CarType carType, double price, String year, String make, String model, int initialQuantity) {
        Car car = new Car(vin, plateNumber, carType, year, make,price, model, initialQuantity);
        return car;
    }

    @Override
    public String toString() {

        return  "Vin Number: " + getVin() + ", " +
                "Plate Number: " + getPlateNumber() + ", " +
                "Type: " + getCarType() + "， " +
                "Price/day: " + getPricePerDay() + ", " +
                "Year: " + getYear() + ", " +
                "Make: " + getMake() + ", " +
                "Model: " + getModel() + ", " +
                "Quantity: " + getInitialQuantity() +" ,"+
                "Vehicle Reserved: " + isReserved() + ".\n";
    }
}
