package com.zenika.exercises;

import com.zenika.tp.java.Exercises;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExercisesDoublingTest {

    @Test
    public void doubling_1_give_2() {
        List<Integer> expected = new ArrayList<>();
        expected.addLast(2);

        List<Integer> actual = new ArrayList<>();
        actual.addLast(1);
        Assertions.assertThat(Exercises.doubling(actual))
            .isEqualTo(expected);
    }

    @Test
    public void doubling_1_2_3_give_2_4_6() {
        List<Integer> expected = new ArrayList<>();
        expected.addLast(2);
        expected.addLast(4);
        expected.addLast(6);

        List<Integer> actual = new ArrayList<>();
        actual.addLast(1);
        actual.addLast(2);
        actual.addLast(3);
        Assertions.assertThat(Exercises.doubling(actual))
            .isEqualTo(expected);
    }

    @Test
    public void doubling_6_moins3_12_23_4_1_19_11_2_3_2_give_12_moins6_24_46_8_2_38_22_4_6_4() {
        List<Integer> expected = Arrays.asList(
                12,
                -6,
                24,
                46,
                8,
                2,
                38,
                22,
                4,
                6,
                4);

        List<Integer> actual = Arrays.asList(
                6,
                -3,
                12,
                23,
                4,
                1,
                19,
                11,
                2,
                3,
                2);

        Assertions.assertThat(Exercises.doubling(actual))
            .isEqualTo(expected);
    }

    @Test
    public void doubling_empty_give_empty() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        Assertions.assertThat(Exercises.doubling(actual))
            .isEqualTo(expected);
    }
}
