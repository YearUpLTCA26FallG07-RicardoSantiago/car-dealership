package com.pluralsight;

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

    }
    public void processAddVehicleRequest() {

    }
    public void processRemoveVehicleRequest() {

    }
}
