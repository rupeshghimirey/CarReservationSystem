package com.client;

import static com.client.GlobalVariable.*;

public class SubMenu2Choice1 {

    private static final double UPPER_CAP_DEPOSIT = 25_000.0;
    private static final double LOWER_CAP_DEPOSIT = 25.0;

    public static void subMenu2Choice1() {

        System.out.println("Your current Balance is: " + currentCustomer.getBalance());
        System.out.println("(1) Add more Balance");
        System.out.println("(2) Previous Menu");

        String addMoreBalance = userInterface.userInput();
        if (addMoreBalance.equals("1")) {
            System.out.println("How much do you want to deposit? " +
                    "(Amount should be in between $" + LOWER_CAP_DEPOSIT + " and $" + UPPER_CAP_DEPOSIT + ")");
            String addAmount = userInterface.userInput();

            try {
                double oneTimeDeposit = Double.parseDouble(addAmount);

                if(oneTimeDeposit > UPPER_CAP_DEPOSIT) {

                    System.out.println("You have reached the cap amount of $" + UPPER_CAP_DEPOSIT +
                            ". And only $" + UPPER_CAP_DEPOSIT + " is deposited.");

                    oneTimeDeposit = UPPER_CAP_DEPOSIT;

                }else if(oneTimeDeposit <= LOWER_CAP_DEPOSIT) {
                    System.out.println("Not enough deposit made this time.");
                }

                currentCustomer.setBalance(currentCustomer.getBalance() + oneTimeDeposit);

                System.out.println("$ "+ oneTimeDeposit + " is added to your current balance!");
                System.out.println("New balance: $" + currentCustomer.getBalance());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\nInvalid input");
            }
        }
    }
}
