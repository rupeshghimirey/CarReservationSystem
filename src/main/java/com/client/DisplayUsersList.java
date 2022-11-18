package com.client;

import com.crs.customer.Customer;
import com.crs.customer.CustomerList;

import java.io.FileNotFoundException;

import static com.client.GlobalVariable.currentCustomer;

public class DisplayUsersList {

    public static void switchUser(Customer selectedCustomer) {
        currentCustomer = selectedCustomer;
    }

    public static Customer selectOptions() {
        Customer selectedCustomer = currentCustomer;

        System.out.println("Please Select The Index of User You Want to Switch Into:");
        String userInput = GlobalVariable.userInterface.userInput();

        int userSize = CustomerList.getCustomerList().size();
        boolean isChangeInvalid = true;

        try{
            int userSelection = Integer.parseInt(userInput);

            if(userSelection > 0 && userSelection <= userSize ) {
                selectedCustomer = CustomerList.getCustomerList().get(userSelection-1);
                isChangeInvalid = false;
            } else {
                System.out.println("Selection Out of Range!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error:" + e);
        }

        if(isChangeInvalid) {
            System.out.println("No Changes Made!");
        }

        return selectedCustomer;
    }

    public static void displayUser() {
        CustomerList customerList = new CustomerList();
        System.out.println("Currently Logged in as: " + currentCustomer.getFirstName() + "\n");
        System.out.println(customerList.toString());
    }

    public static void SwitchUserMenu() throws FileNotFoundException {
        displayUser();

        switchUser(selectOptions());
    }
}


