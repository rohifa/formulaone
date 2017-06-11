package com.formulaone.model;

import java.util.Map;

/**
 * Created by r0h1 on 10-Jun-17.
 */
public class Main {
    public static void main(String... args) {
        int numberOfCars = 1;
        int trackLength = 100;
        int range = 10;

        CarStep step = new CarStep(numberOfCars, trackLength, range);
        Map<Car, Integer> cars = step.step();
        for (Map.Entry<Car, Integer> car: cars.entrySet()) {
            System.out.println("the car with index " + car.getKey().getIndex() + " arrived after" + car.getValue() + " seconds");
        }

    }
}
