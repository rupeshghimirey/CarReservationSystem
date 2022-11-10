package com.client;

import com.crs.datahub.CarInventory;

public class CRSClient {
    public static void main(String[] args) {
        CarInventory carInventory = new CarInventory();

        carInventory.carInventoryInitialization();

        System.out.println(carInventory.getCarInventory());

        for(String vin : carInventory.carInventory.keySet()) {
            System.out.println(carInventory.carInventory.get(vin));
        }

    }
}
