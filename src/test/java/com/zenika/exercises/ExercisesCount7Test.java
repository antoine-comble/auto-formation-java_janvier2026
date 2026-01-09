package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesCount7Test {

    @Test
    void count7_0_give_0() {
        Assertions.assertEquals(0, Exercises.count7(0));
    }

    @Test
    void count7_1_give_0() {
        Assertions.assertEquals(0, Exercises.count7(1));
    }

    @Test
    void count7_2_give_0() {
        Assertions.assertEquals(0, Exercises.count7(2));
    }

    @Test
    void count7_7_give_1() {
        Assertions.assertEquals(1, Exercises.count7(7));
    }

    @Test
    void count7_123_give_0() {
        Assertions.assertEquals(0, Exercises.count7(123));
    }

    @Test
    void count7_727_give_2() {
        System.out.println(727%7);
        Assertions.assertEquals(2, Exercises.count7(727));
    }

}
