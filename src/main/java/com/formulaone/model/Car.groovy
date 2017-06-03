package com.formulaone.model

/**
 * Created by r0h1 on 03-Jun-17.
 */
class Car {
    int index
    int topSpeed
    int acceleration
    int handlingFactor
    boolean nitroAvailable
    int speed
    int position = 0


    Car(int index) {
        this.index = index
        this.topSpeed = 150 + 10*index
        this.acceleration = 2*index
        this.handlingFactor = 0.8
        this.nitroAvailable = true
        this.speed = 0
        this.position = calculateInitialPosition()
    }

    int calculateInitialPosition() {
        int startPosition = 0
        0.upto(index-1) {
            startPosition = startPosition + 200 * it
        }
        return -startPosition
    }


}
