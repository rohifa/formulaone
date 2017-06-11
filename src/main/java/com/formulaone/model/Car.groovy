package com.formulaone.model

import static com.formulaone.model.SpeedUtils.*

/**
 * Created by r0h1 on 03-Jun-17.
 */
class Car {
    int index
    float topSpeed
    float acceleration
    int handlingFactor
    boolean nitroAvailable
    float speed
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

    void slowDown(int seconds) {
        this.speed = handlingFactor * speed
        updateToNextPosition(seconds)
    }

    void updateToNextPosition(int seconds) {
        def speedmps = kphToMps(speed)
        def newPosition = this.position + distanceAfterAcceleration(speedmps, acceleration, seconds)
        this.position = newPosition
    }

    void accelerate(int seconds) {
        def speedmps = kphToMps(speed)
        def newSpeed = speedmps + acceleration*seconds
        this.speed = newSpeed
        updateToNextPosition(seconds)
    }
}
