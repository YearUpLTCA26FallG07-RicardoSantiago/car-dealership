package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

     // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
         //constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    //get all vehicles Methods
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }
    //Add Vehicle Method
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    //Remove Vehicle Method
    public void removeVehicle(int vin){

        Vehicle vehicleToRemove = null;

        for(Vehicle vehicle : inventory) {

            if (vehicle.getVin() == vin) {

                vehicleToRemove = vehicle;

            }
        }

        if (vehicleToRemove != null) {
            inventory.remove(vehicleToRemove);
        }

    }

    //Search by price
    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {

        List<Vehicle> matchingVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory) {

            if (vehicle.getPrice().compareTo(min) >=0 && vehicle.getPrice().compareTo(max) <=0) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    //Search by Make/Model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {

        List<Vehicle> matchingVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory) {
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {

                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    //Search by Year
    public List<Vehicle> getVehiclesByYear(int min, int max){

        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    //Search by Color
    public List<Vehicle> getVehiclesByColor(String color) {

        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    //Search by Mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max){

        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;

    }

    //Search By Type
    public List<Vehicle> getVehiclesByType(String vehicleType){

        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }



}
