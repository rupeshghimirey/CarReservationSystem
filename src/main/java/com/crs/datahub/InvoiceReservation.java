package com.crs.datahub;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceReservation {
    // creates newFile with invoice.txt
    File newFile = new File("invoice.txt");
    // prints out the output file
    PrintWriter writer;
    Date date = new Date();
    // hh for 12hr format, aa for PM/AM
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");

    // creates constructor with try catch and create newFile
    public InvoiceReservation() {
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            writer = new PrintWriter(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // prints out in output file whenever this method is called in CRSClient
    public void selectCar() {
        writer.println(dateFormat.format(date) + " Car Reservation Done!");
    }
    public void inventoryPeeked() {
        writer.println(dateFormat.format(date) + " Inventory is seen by client");
    }
    // close the audit printer after the program exits
    public void closeFile() {
        writer.close();
    }
}
