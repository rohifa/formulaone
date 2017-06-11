package com.formulaone.model

import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by r0h1 on 03-Jun-17.
 */
class CarTest {

    @Test
    void checkStartPosition() {

        Car[] cars = [
                [1], [2], [3], [4]
        ]
        assertEquals(0, cars[0].position)
        assertEquals(-200, cars[1].position)
        assertEquals(-600, cars[2].position)
        assertEquals(-1200, cars[3].position)
    }
}