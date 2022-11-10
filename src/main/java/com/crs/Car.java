package com.crs;

import java.util.Date;

public class Car {
   private String make;
    private CarType carType;
    private String model;
    private String year;
    private double price;
    private boolean isReserved;

    public Car(String make, CarType carType, String model, String year, double price) {
        this.make = make;
        this.carType = carType;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.price, price) != 0) return false;
        if (isReserved != car.isReserved) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (carType != car.carType) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return year != null ? year.equals(car.year) : car.year == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = make != null ? make.hashCode() : 0;
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isReserved ? 1 : 0);
        return result;
    }
}
