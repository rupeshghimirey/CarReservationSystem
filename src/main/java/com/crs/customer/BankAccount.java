package com.crs.customer;

public class BankAccount implements IPayment{
    private String name;
    private String accountType;
    private String routingNumber;
    private String accountNumber;

    public BankAccount(String name, String accountType, String routingNumber, String accountNumber) {
        this.name = name;
        this.accountType = accountType;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", routingNumber='" + routingNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
