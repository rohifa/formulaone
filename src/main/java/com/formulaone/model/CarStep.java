package com.formulaone.model;

import java.util.*;

/**
 * Created by r0h1 on 05-Jun-17.
 */
public class CarStep {

    private int numberOfCars, trackLength, range;

    public CarStep(int numberOfCars, int trackLength, int range) {
        this.numberOfCars = numberOfCars;
        this.trackLength = trackLength;
        this.range = range;
    }
    //the loop will finish when initial list is empty (or new list is full)
    //check position of each car. If someone has reached destination, remove it from the list. Add to another list with the time it took (number of seconds)s
    //on each step, get all cars to slow down and update their speed.
    //check position of each car, last one gets nitro if it still has it - update its speed (unless it was decreased already)


    private Set<Car> initializeCars(int numberOfCars) {
        Set<Car> cars = new HashSet<>();
        for (int i=1; i<=numberOfCars; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
        return cars;
    }

    public Map<Car, Integer> step() {
        Map<Car, Integer> carsCompleted = new HashMap<>();
        Set<Car> cars = initializeCars(numberOfCars);
        int seconds = 0;
        while (carsCompleted.size()< numberOfCars) {

            //slow down cars too near to each other
            DistanceCalculator distanceCalculator = new DistanceCalculator();
            Set<Car> carsToSlowDown = distanceCalculator.carsToSlowDown(cars, range);
            for (Car car: carsToSlowDown) {
                car.slowDown(seconds);
            }

            for (Iterator<Car> it = cars.iterator(); it.hasNext(); ) {
                Car car = it.next();

                //add cars who completed the track to a separate map, with
                if (car.getPosition()>= trackLength) {
                    carsCompleted.put(car, seconds);
                    it.remove();
                }
                //accelerate cars that didn't slow down
                if (!carsToSlowDown.contains(car)) car.accelerate(seconds);
            }
            seconds = seconds+2;
        }
        return carsCompleted;
    }

}
