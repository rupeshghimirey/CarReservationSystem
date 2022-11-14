package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CarFileReader {

    private Scanner scanner;
    private File itemFile;

    public Map<String, Car> loadCarInventory(int initialQuantity) throws FileNotFoundException {

        itemFile = new File("CRSFileSystem.csv");
        Map<String, Car> newMap = new TreeMap<>();
        scanner = new Scanner(itemFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] fields = line.split("\\|");
            Car item = new Car(fields[0], fields[1], CarType.valueOf(fields[2]), fields[3],
                    fields[4], Double.parseDouble(fields[5]), fields[6]);
            newMap.put(fields[0], item);
        }
        return newMap;
    }

}
