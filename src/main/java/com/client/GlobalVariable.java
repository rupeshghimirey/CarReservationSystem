package com.client;

import com.crs.customer.Customer;
import com.crs.datahub.InvoiceReservation;
import com.crs.models.UserInterface;

import java.util.HashMap;
import java.util.Map;

public class GlobalVariable {

    public static final String MAIN_OPTION_1 = "1";
    public static final String MAIN_OPTION_2 = "2";
    public static final String MAIN_OPTION_3 = "3";
    public static final String MAIN_OPTION_4 = "4";
    public static final String SUB_OPTION_1 = "1";
    public static final String SUB_OPTION_2 = "2";
    public static final String SUB_OPTION_3 = "3";
    public static final String SUB_OPTION_4 = "4";

    public static UserInterface userInterface;

    public static InvoiceReservation invoiceReservation;

    public static boolean isSubMenu2Choice = true;

    public static Customer currentCustomer;

    public static Map<String, Integer> MainMenu_LevelZero = new HashMap<>();

}
