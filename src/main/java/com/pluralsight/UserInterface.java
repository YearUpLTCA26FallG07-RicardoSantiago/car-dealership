package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;

public class UserInterface {

    private Dealership dealership;

    public UserInterface(){

    }
    //load the info from other classes
    private void init(){

        DealershipFileManager loader = new DealershipFileManager();

        dealership = loader.getDealership();


    }
    public void display() {
        init();
        int command;

        do {

        System.out.println("""
           *********************************************************
           *                                                       *
           *                  D & B USED CARS                      *
           *                                                       *
           *********************************************************
           *                                                       *
           *  [1]  Find Vehicles by Price Range                    *
           *  [2]  Find Vehicles by Make / Model                   *
           *  [3]  Find Vehicles by Year Range                     *
           *  [4]  Find Vehicles by Color                          *
           *  [5]  Find Vehicles by Mileage Range                  *
           *  [6]  Find Vehicles by Vehicle Type                   *
           *  [7]  Display All Vehicles                            *
           *  [8]  Add a Vehicle                                   *
           *  [9]  Remove a Vehicle                                *
           *                                                       *
           *********************************************************
           *                                                       *
           *  [99] Exit Application                                *
           *                                                       *
           *********************************************************
           """);

        //Switch for the UI
            command = Console.promptForInt("Please enter your selection: ");

            switch (command) {

                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("Have a nice day");
                default -> System.out.println("Invalid input, please use one of the inputs listed");

            }
        } while (command !=99);


    }
    public void processGetByPriceRequest() {

        BigDecimal min = new BigDecimal(Console.promptForString("Enter the mininum: "));

        BigDecimal max = new BigDecimal(Console.promptForString("Enter the maximum: "));

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min,max);

        displayVehicles(vehicles);

    }
    public void processGetByMakeModelRequest() {

        String make = Console.promptForString("Enter the make of the car: ");

        String model = Console.promptForString("Enter the model of the car: ");

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make,model);

        displayVehicles(vehicles);

    }
    public void processGetByYearRequest() {

        int min = Console.promptForInt("Enter the mininum year");
        int max = Console.promptForInt("Enter the Max year: ");

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min,max);
        displayVehicles(vehicles);

    }
    public void processGetByColorRequest() {

        String color = Console.promptForString("Enter the color: ");

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);

        displayVehicles(vehicles);

    }
    public void processGetByMileageRequest() {

        int min = Console.promptForInt("Enter the minimum miles: ");
        int max = Console.promptForInt("Enter the Max miles: ");

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min,max);
        displayVehicles(vehicles);

    }
    public void processGetByVehicleTypeRequest() {

        String vehicleType = Console.promptForString("Enter the vehicle type: ");
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);

    }
    public void processGetAllVehiclesRequest() {

        displayVehicles(dealership.getAllVehicles());

    }
    public void processAddVehicleRequest() {

        int vin = Console.promptForInt("Enter the VIN: ");

        int year = Console.promptForInt("Enter the Year: ");

        String make = Console.promptForString("Enter the make");

        String model = Console.promptForString("Enter the model: ");

        String vehicleType = Console.promptForString("Enter the vehicle Type: ");

        String color = Console.promptForString("Enter the color: ");

        int odometer = Console.promptForInt("Enter the odometer reading: ");

        BigDecimal price = new BigDecimal(Console.promptForInt("Enter the price: "));

        Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color, odometer,price);

        dealership.addVehicle(vehicle);

        System.out.println(vehicle +"Has been added successfully");


    }
    public void processRemoveVehicleRequest() {

        int vin = Console.promptForInt("Enter the VIN: ");

        dealership.removeVehicle(vin);

        System.out.println("Vehicle has been successfully removed.");

    }
    private void displayVehicles(List<Vehicle>vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);


        }
    }
}
