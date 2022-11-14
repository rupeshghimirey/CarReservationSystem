package com.crs.customer;

public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private Address address;
    private IPayment payment;

    public Customer(String id, String name, String phoneNumber, Address address, IPayment payment) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.payment = payment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public IPayment getPayment() {
        return payment;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", payment=" + payment +
                '}';
    }
}
