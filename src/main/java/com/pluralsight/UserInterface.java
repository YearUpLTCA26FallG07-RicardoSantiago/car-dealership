package com.pluralsight;

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

    }
    public void processGetByMakeModelRequest() {

    }
    public void processGetByYearRequest() {

    }
    public void processGetByColorRequest() {

    }
    public void processGetByMileageRequest() {

    }
    public void processGetByVehicleTypeRequest() {

    }
    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());

    }
    public void processAddVehicleRequest() {


    }
    public void processRemoveVehicleRequest() {

    }
    private void displayVehicles(List<Vehicle>vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);


        }
    }
}
