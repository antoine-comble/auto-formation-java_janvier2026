package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesTriangleTest {

    @Test
    void triangle_0_give_0() {
        Assertions.assertEquals(0, Exercises.triangle(0));
    }

    @Test
    void triangle_1_give_1() {
        Assertions.assertEquals(1, Exercises.triangle(1));
    }

    @Test
    void triangle_2_give_3() {
        Assertions.assertEquals(3, Exercises.triangle(2));
    }

    @Test
    void triangle_5_give_15() {
        Assertions.assertEquals(15, Exercises.triangle(5));
    }

    @Test
    void triangle_10_give_55() {
        Assertions.assertEquals(55, Exercises.triangle(10));
    }
}
