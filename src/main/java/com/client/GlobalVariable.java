package com.client;

import com.crs.customer.Address;
import com.crs.customer.CreditCard;
import com.crs.customer.Customer;
import com.crs.datahub.InvoiceReservation;
import com.crs.models.UserInterface;

public class GlobalVariable {

    public static final String MAIN_OPTION_1 = "1";
    public static final String MAIN_OPTION_2 = "2";
    public static final String MAIN_OPTION_3 = "3";
    public static final String MAIN_OPTION_4 = "4";
    public static final String SUB_OPTION_1 = "1";
    public static final String SUB_OPTION_2 = "2";
    public static final String SUB_OPTION_3 = "3";
    public static final String SUB_OPTION_4 = "4";

    public static boolean isMenuRunning = true;

    public static UserInterface userInterface;

    public static InvoiceReservation invoiceReservation;

    public static boolean isSubMenu2Choice = true;

    public static Customer currentCustomer = new Customer("1", "Rupesh", "Ghimire", "123-456-7891",
            new Address("86 Boston Hbr", "Cameron", "NC", "28326"),
            new CreditCard("Rupesh", "1111 2222 3333 4444", "222", "10/45") {});

}
