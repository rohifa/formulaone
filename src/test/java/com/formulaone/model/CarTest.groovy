package com.formulaone.model

import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by r0h1 on 03-Jun-17.
 */
class CarTest {

    @Test
    void checkStartPosition() {
        def car1 = new Car(1)
        assertEquals(0, car1.position)

        def car2 = new Car(2)
        assertEquals(-200, car2.position)

        def car3 = new Car(3)
        assertEquals(-600, car3.position)

        def car4 = new Car(4)
        assertEquals(-1200, car4.position)
    }

}