package com.client;

import com.crs.customer.Customer;

public class MainMenuOption2 {
    public static void mainMenuOption2(Customer customer) {
        String subMenu2Choice = GlobalVariable.userInterface.printSubMenuOfTwo();
        GlobalVariable.isSubMenu2Choice = true;

        while (GlobalVariable.isSubMenu2Choice) {
            if (subMenu2Choice.equals(CRSClient.SUB_OPTION_1)) {

                SubMenu2Choice1.subMenu2Choice1(customer);

                GlobalVariable.isSubMenu2Choice = false;
            } else if (subMenu2Choice.equals(CRSClient.SUB_OPTION_2)) {

                SubMenu2Choice2.subMenu2Choice2(customer);

                GlobalVariable.isSubMenu2Choice = false;

            } else if (subMenu2Choice.equals(CRSClient.SUB_OPTION_3)) {
                SubMenu2Choice3.subMenu2Choice3(customer);

                GlobalVariable.isSubMenu2Choice = false;
            } else if (subMenu2Choice.equals(CRSClient.SUB_OPTION_4)) {
                GlobalVariable.isSubMenu2Choice = false;
            }
        }
    }
}
