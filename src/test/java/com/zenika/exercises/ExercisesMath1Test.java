package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExercisesMath1Test {

    @Test
    public void math1_10_give_110() {
        List<Integer> expected = new ArrayList<>();
        expected.add(110);
        List<Integer> actual = new ArrayList<>();
        actual.add(10);
        Assertions.assertArrayEquals(expected.toArray(), Exercises.math1(actual).toArray());
    }

    @Test
    public void math1_1_2_3_give_20_30_40() {
        List<Integer> expected = new ArrayList<>();
        expected.add(20);
        expected.add(30);
        expected.add(40);
        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        Assertions.assertArrayEquals(expected.toArray(), Exercises.math1(actual).toArray());
    }
}
