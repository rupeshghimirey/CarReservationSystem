package com.crs.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {
    private static List<Customer> customerList = new ArrayList<>();

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    @Override
    public String toString() {
        String customerListString = "";
        int i = 1;
        for(Customer customer:customerList) {
            customerListString += i++ + ". " +
                    "ID: " + customer.getId() + ", " +
                    "First Name: " + customer.getFirstName() + ", " +
                    "Last Name: " + customer.getLastName() + ".\n";
        }
        return customerListString;
    }
}
