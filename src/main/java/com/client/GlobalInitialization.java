package com.client;

import com.crs.customer.Address;
import com.crs.customer.CreditCard;
import com.crs.customer.Customer;
import com.crs.customer.CustomerList;
import com.crs.datahub.InvoiceReservation;
import com.crs.models.UserInterface;

import java.io.FileNotFoundException;

import static com.client.GlobalVariable.*;

public class GlobalInitialization {
    public static void globeInitializationStart() throws FileNotFoundException {

        Customer customer1 = new Customer("1", "Rupesh", "Ghimire", "123-456-7891",
                new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
                new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {});

        Customer customer2 = new Customer("2", "Alex", "Aguilar", "123-456-7891",
                new Address("1918 8th Ave", "Seattle", "WA", "98101"),
                new CreditCard("Alex", "1111 2222 3333 4444", "222", "10/45") {});

        Customer customer3 = new Customer("3", "Chongwei", "Ma", "123-456-7891",
                new Address("1918 8th Ave", "Seattle", "WA", "98101"),
                new CreditCard("Chongwei", "1111 2222 3333 4444", "222", "10/45") {});

        CustomerList.getCustomerList().add(customer1);
        CustomerList.getCustomerList().add(customer2);
        CustomerList.getCustomerList().add(customer3);

        userInterface = new UserInterface();

        invoiceReservation = new InvoiceReservation();

        currentCustomer = CustomerList.getCustomerList().get(1);

    }
}
