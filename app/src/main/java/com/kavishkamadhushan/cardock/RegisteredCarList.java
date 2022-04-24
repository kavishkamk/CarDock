package com.kavishkamadhushan.cardock;

import java.util.ArrayList;

public class RegisteredCarList {

    private static ArrayList<Car> cars;
    private static RegisteredCarList registeredCarList;
    private static int carId = 0;

    private RegisteredCarList() {
        cars = new ArrayList<>();
    }

    public static RegisteredCarList getRegisteredCarList() {
        if (registeredCarList == null) {
            registeredCarList = new RegisteredCarList();
        }
        return registeredCarList;
    }

    public void addCar(Car car) {
        car.setCarId(++carId);
        RegisteredCarList.cars.add(car);
    }

}
