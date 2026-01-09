package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesDiff21Test {

    @Test
    public void diff21_with_22() {
        Assertions.assertEquals(1, Exercises.diff21(22));
    }

    @Test
    public void diff21_with_23() {
        Assertions.assertEquals(2, Exercises.diff21(23));
    }

    @Test
    public void diff21_with_19() {
        Assertions.assertEquals(2, Exercises.diff21(19));
    }

    @Test
    public void diff21_with_10() {
        Assertions.assertEquals(11, Exercises.diff21(10));
    }

    @Test
    public void diff21_with_21() {
        Assertions.assertEquals(0, Exercises.diff21(21));
    }

    @Test
    public void diff21_with_25() {
        Assertions.assertEquals(4, Exercises.diff21(25));
    }

    @Test
    public void diff21_with_30() {
        Assertions.assertEquals(9, Exercises.diff21(30));
    }

    @Test
    public void diff21_with_0() {
        Assertions.assertEquals(21, Exercises.diff21(0));
    }

    @Test
    public void diff21_with_1() {
        Assertions.assertEquals(20, Exercises.diff21(1));
    }

    @Test
    public void diff21_with_2() {
        Assertions.assertEquals(19, Exercises.diff21(2));
    }

    @Test
    public void diff21_with_moins_1() {
        Assertions.assertEquals(22, Exercises.diff21(-1));
    }

    @Test
    public void diff21_with_moins_2() {
        Assertions.assertEquals(23, Exercises.diff21(-2));
    }

    @Test
    public void diff21_with_50() {
        Assertions.assertEquals(29, Exercises.diff21(50));
    }
}
