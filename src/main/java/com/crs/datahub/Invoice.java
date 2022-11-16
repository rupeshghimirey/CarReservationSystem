package com.crs.datahub;

import com.crs.customer.Customer;
import com.crs.models.Car;

public class Invoice {

    private Customer customer;
    private ReservedPeriods reservedPeriods;
    private Car car;

    public Invoice() {}

    public Invoice(Customer customer, ReservedPeriods reservedPeriods, Car car) {
        this.customer = customer;
        this.reservedPeriods = reservedPeriods;
        this.car = car;
    }

    public ReservedPeriods getReservedPeriods() {
        return reservedPeriods;
    }

    public void setReservedPeriods(ReservedPeriods reservedPeriods) {
        this.reservedPeriods = reservedPeriods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return customer.toString() + "\n" +
                reservedPeriods.toString() + "\n" +
                car.toString() +
                "\n";
    }
}
