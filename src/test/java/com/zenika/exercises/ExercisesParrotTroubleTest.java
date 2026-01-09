package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesParrotTroubleTest {

    @Test
    public void parrotTrouble_hour7_isTalking() {
        Assertions.assertFalse(Exercises.parrotTrouble(true, 7));
    }

    @Test
    public void parrotTrouble_hour6_isTalking() {
        Assertions.assertTrue(Exercises.parrotTrouble(true, 6));
    }

    @Test
    public void parrotTrouble_hour6_notTalking() {
        Assertions.assertFalse(Exercises.parrotTrouble(false, 6));
    }

    @Test
    public void parrotTrouble_hour21_isTalking() {
        Assertions.assertTrue(Exercises.parrotTrouble(true, 21));
    }

    @Test
    public void parrotTrouble_hour21_notTalking() {
        Assertions.assertFalse(Exercises.parrotTrouble(false, 21));
    }
}
