package com.client;

import com.crs.customer.Address;
import com.crs.customer.CreditCard;
import com.crs.customer.Customer;
import com.crs.models.CarCost;

public class LocalDataInitialization {
    private static Customer customer1;
    //private static CarCost carCost;

    public Customer getCustomer1() {
        return customer1;
    }

    public static void initializationForAll() {
        customer1 = new Customer("1", "Rupesh", "Ghimire", "123-456-7891",
                new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
                new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {

                });

        CarCost.costInitialization();
    }
}
