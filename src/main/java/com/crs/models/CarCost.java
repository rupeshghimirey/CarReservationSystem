package com.crs.models;

import java.util.HashMap;
import java.util.Map;

public class CarCost {
    public final static Map<CarType, Integer> costChart = new HashMap<>();

    public static void costInitialization() {
        costChart.put(CarType.LUXURY, 400);
        costChart.put(CarType.SPORTS, 350);
        costChart.put(CarType.SUV, 300);
        costChart.put(CarType.JEEP, 250);
        costChart.put(CarType.VAN, 200);
        costChart.put(CarType.SEDAN, 100);
    }

    public static double totalCharge(Car car, long numberOfDays) {
        costInitialization();

        double totalCharge = costChart.get(car.getCarType()) * numberOfDays;

        return totalCharge;
    }
}
