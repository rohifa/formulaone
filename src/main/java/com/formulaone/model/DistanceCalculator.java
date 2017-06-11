package com.formulaone.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.abs;

/**
 * Created by r0h1 on 03-Jun-17.
 */
public class DistanceCalculator {

    /**
     * returns a list of cars to slow down
     */
    public Set<Car> carsToSlowDown(Collection<Car> cars, int range) {
        Set<Car> carsToSlowDown = new HashSet<>();
        for (Car car: cars) {
            Set<Car> nearby = getNearbyCars(car, cars, range);
            carsToSlowDown.addAll(nearby);
        }
        return carsToSlowDown;
    }

    /**
     * get cars nearby by a certain range
     */
    private Set<Car> getNearbyCars(Car car, Collection<Car> cars, int range) {
        Set<Car> nearby = new HashSet<>();
        for (Car c: cars) {
            if (c != car && distanceBetween(c, car) <= range) nearby.add(c);
        }
        return nearby;
    }

    private float distanceBetween(Car c, Car car) {
        return abs(c.getPosition() - car.getPosition());
    }
}
