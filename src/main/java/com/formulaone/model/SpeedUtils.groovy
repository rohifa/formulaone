package com.formulaone.model

/**
 * Created by r0h1 on 10-Jun-17.
 */
class SpeedUtils {

    static float kphToMps(float kph) {
        return 3.6 * kph
    }

    static float mpsTpKph(float mps) {
        return  0.277 * mps
    }

    static float distanceAfterAcceleration(float initialSpeed, float acceleration, int seconds) {
        //s = vt + 0.5 att
        return initialSpeed*seconds + 0.5*acceleration+seconds*seconds
    }

}
