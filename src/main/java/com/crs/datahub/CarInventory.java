package com.crs.datahub;

import com.crs.models.Car;

import java.io.FileNotFoundException;
import java.util.*;

public class CarInventory {

    private static int initialQuantity = 5;
    private Map<String,Car> myMap = new TreeMap<>();

    public Map<String, Car> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, Car> myMap) {
        this.myMap = myMap;
    }

    CarFileReader reader = new CarFileReader();

    public CarInventory() throws FileNotFoundException {
        myMap = reader.processCarInventory(initialQuantity);
    }

    public Map<String,Car> getCarCollections() {
        return myMap;
    }

}
