package com.crs.models;

import java.util.List;

public class CarCost {
    final static int LUXURY_COST= 400;
    final static int SPORTS_COST= 350;
    final static int SUV_COST= 300;
    final static int JEEP_COST= 250;
    final static int VAN_COST= 200;
    final static int SEDAN_COST= 100;

    public static double totalPrice(CarType carType, int numberOfDays) {
        double totalCost = 0.0;
        if (carType.equals(CarType.LUXURY)){
            totalCost = LUXURY_COST + numberOfDays;
        }
        else if (carType.equals(CarType.SPORTS)){
            totalCost = SPORTS_COST + numberOfDays;
        }
        else if (carType.equals(CarType.SUV)){
            totalCost = SUV_COST + numberOfDays;
        }
        else if (carType.equals(CarType.JEEP)){
            totalCost = JEEP_COST + numberOfDays;
        }
        else if (carType.equals(CarType.VAN)){
            totalCost = VAN_COST + numberOfDays;
        }
        else if (carType.equals(CarType.SEDAN)){
            totalCost = SEDAN_COST + numberOfDays;
        }
        return totalCost;
    }

}
