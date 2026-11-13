package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class DealershipFileManager {


    //Reader for inventory file
    public Dealership getDealership(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));

            //Reading the file and naming the parts
            String dealershipname = reader.readLine();

            String[] dealershipinfo = dealershipname.split("\\|");

            String name = dealershipinfo[0];
            String address= dealershipinfo[1];
            String phone = dealershipinfo[2];

            //Stating dealership object
            Dealership dealership = new Dealership(name,address,phone);

            //Reading the Vehicles
            String line;

            while ((line = reader.readLine()) !=null) {
                String[] car = line.split("\\|");

                int vin = Integer.parseInt(car[0]);
                int year = Integer.parseInt(car[1]);
                String make = car[2];
                String model = car[3];
                String type = car[4];
                String color = car[5];
                int odometer = Integer.parseInt(car[6]);
                BigDecimal price = new BigDecimal(car[7]);

                //Stating the vehicle object
                Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);

                //Adding the vehicle object into the dealership object
                dealership.addVehicle(vehicle);
            }
            reader.close();
            return dealership;

        } catch (IOException e) {
            System.out.println("Error in file, try again");
        }
        return null;
    }

    public void saveDealership(Dealership dealership) {

    }
}
