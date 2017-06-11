package com.formulaone.model

import org.junit.Test

import static org.junit.Assert.assertTrue

/**
 * Created by r0h1 on 10-Jun-17.
 */
class DistanceCalculatorTest {

    @Test
    void testCarsToSlowDown() {
        List<Car> cars = carsInPosition()
        DistanceCalculator calculator = new DistanceCalculator()
        def slowCars = calculator.carsToSlowDown(cars, 4)
        assertTrue(slowCars.contains(cars[0]))
        assertTrue(slowCars.contains(cars[1]))

    }


    List<Car> carsInPosition() {

        def car1 = new Car(1)
        def car2 = new Car(2)
        def car3 = new Car(3)
        def car4 = new Car(4)
        car1.position = 1
        car2.position = 2
        car3.position = 10
        car4.position = 18
        def cars = [
                car1, car2, car3, car4
        ]
        return cars
    }



}