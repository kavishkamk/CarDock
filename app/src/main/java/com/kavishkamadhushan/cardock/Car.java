package com.kavishkamadhushan.cardock;

// this is car class

public class Car {

    private int carId;
    private String brand;
    private String model;
    private String fuelType;
    private String transmissionType;
    private String color;
    private String ownerUserName;
    private int manufactureYear;
    private int kilometersDriven;
    private int numOfOwners;
    private double expectedPrice;

    public Car(int carId, String brand, String model, String fuelType, String transmissionType, String color, String ownerUserName, int manufactureYear, int kilometersDriven, int numOfOwners, double expectedPrice) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.color = color;
        this.ownerUserName = ownerUserName;
        this.manufactureYear = manufactureYear;
        this.kilometersDriven = kilometersDriven;
        this.numOfOwners = numOfOwners;
        this.expectedPrice = expectedPrice;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getKilometersDriven() {
        return kilometersDriven;
    }

    public void setKilometersDriven(int kilometersDriven) {
        this.kilometersDriven = kilometersDriven;
    }

    public int getNumOfOwners() {
        return numOfOwners;
    }

    public void setNumOfOwners(int numOfOwners) {
        this.numOfOwners = numOfOwners;
    }

    public double getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }
}
