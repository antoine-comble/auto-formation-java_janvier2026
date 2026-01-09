package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExercisesRightDigitTest {

    @Test
    public void rightDigit_1_22_93_give_1_2_3() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(22);
        actual.add(93);
        Assertions.assertArrayEquals(expected.toArray(), Exercises.rightDigit(actual).toArray());
    }
}
