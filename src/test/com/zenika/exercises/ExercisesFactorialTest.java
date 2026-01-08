package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesFactorialTest {

    @Test
    public void factorial_1_give_1() {
        Assertions.assertEquals(1, Exercises.factorial(1));
    }

    @Test
    public void factorial_3_give_6() {
        Assertions.assertEquals(6, Exercises.factorial(3));
    }

    @Test
    public void factorial_6_give_720() {
        Assertions.assertEquals(720, Exercises.factorial(6));
    }

    @Test
    public void factorial_10_give_3628800() {
        Assertions.assertEquals(3628800, Exercises.factorial(10));
    }
}
