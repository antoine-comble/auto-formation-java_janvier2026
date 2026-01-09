package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesFibonacciTest {

    @Test
    public void fibonnacci_1_give_1() {
        Assertions.assertEquals(1, Exercises.fibonacci(1));
    }

    @Test
    public void fibonnacci_0_give_0() {
        Assertions.assertEquals(0, Exercises.fibonacci(0));
    }

    @Test
    public void fibonnacci_2_give_1() {
        Assertions.assertEquals(1, Exercises.fibonacci(2));
    }

    @Test
    public void fibonnacci_7_give_13() {
        Assertions.assertEquals(13, Exercises.fibonacci(7));
    }

    @Test
    public void bunnyEars2_0_give_0() {
        Assertions.assertEquals(0, Exercises.bunnyEars2(0));
    }
}
