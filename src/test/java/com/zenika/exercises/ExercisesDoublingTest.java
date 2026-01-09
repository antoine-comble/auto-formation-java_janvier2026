package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExercisesDoublingTest {

    @Test
    public void doubling_1_give_2() {
        List<Integer> expected = new ArrayList<>();
        expected.addLast(2);

        List<Integer> actual = new ArrayList<>();
        actual.addLast(1);
        Assertions.assertArrayEquals(expected.toArray(), Exercises.doubling(actual).toArray());
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
        Assertions.assertArrayEquals(expected.toArray(), Exercises.doubling(actual).toArray());
    }

    @Test
    public void doubling_6_moins3_12_23_4_1_19_11_2_3_2_give_12_moins6_24_46_8_2_38_22_4_6_4() {
        List<Integer> expected = new ArrayList<>();
        expected.addLast(12);
        expected.addLast(-6);
        expected.addLast(24);
        expected.addLast(46);
        expected.addLast(8);
        expected.addLast(2);
        expected.addLast(38);
        expected.addLast(22);
        expected.addLast(4);
        expected.addLast(6);
        expected.addLast(4);

        List<Integer> actual = new ArrayList<>();
        actual.addLast(6);
        actual.addLast(-3);
        actual.addLast(12);
        actual.addLast(23);
        actual.addLast(4);
        actual.addLast(1);
        actual.addLast(19);
        actual.addLast(11);
        actual.addLast(2);
        actual.addLast(3);
        actual.addLast(2);

        Assertions.assertArrayEquals(expected.toArray(), Exercises.doubling(actual).toArray());
    }

    @Test
    public void doubling_empty_give_empty() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        Assertions.assertArrayEquals(expected.toArray(), Exercises.doubling(actual).toArray());
    }
}
