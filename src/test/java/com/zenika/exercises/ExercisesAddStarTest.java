package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExercisesAddStarTest {

    @Test
    public void addStar_a_bb_ccc_give_aStar_bbStar_cccStar() {
        List<String> expected = new ArrayList<>();
        expected.add("a*");
        expected.add("bb*");
        expected.add("ccc*");
        List<String> actual = new ArrayList<>();
        actual.add("a");
        actual.add("bb");
        actual.add("ccc");
        Assertions.assertArrayEquals(expected.toArray(), Exercises.addStar(actual).toArray());
    }

    @Test
    public void addStar_star_give_starStar() {
        List<String> expected = new ArrayList<>();
        expected.add("**");
        List<String> actual = new ArrayList<>();
        actual.add("*");
        Assertions.assertArrayEquals(expected.toArray(), Exercises.addStar(actual).toArray());
    }
}
