package com.client;

import static com.client.GlobalVariable.*;

public class MainMenuOption2 {
    public static void mainMenuOption2() {    
        while (isSubMenu2Choice) {
            String subMenu2Choice = userInterface.printSubMenuTwo();
            
            if (subMenu2Choice.equals(SUB_OPTION_1)) {

                SubMenu2Choice1.subMenu2Choice1();

            } else if (subMenu2Choice.equals(SUB_OPTION_2)) {

                SubMenu2Choice2.subMenu2Choice2();

            } else if (subMenu2Choice.equals(SUB_OPTION_3)) {
                
                SubMenu2Choice3.subMenu2Choice3();
                
            } else if (subMenu2Choice.equals(SUB_OPTION_4)) {
                break;
            }
        }
    }
}
