package com.crs.datahub;

import com.crs.models.Car;
import com.crs.models.CarType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarFileReader {

    private Scanner scanner;
    private File itemFile;

    public List<Car> processCarInventory() throws FileNotFoundException {

        itemFile = new File("CRSFileSystem.csv");
        List<Car> carList = new ArrayList<>();
        scanner = new Scanner(itemFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] fields = line.split("\\|");
            Car car = new Car(fields[0], fields[1], CarType.valueOf(fields[2]), fields[3],
                    fields[4], Double.parseDouble(fields[5]), fields[6]);
            carList.add(car);
        }
        return carList;
    }

}
