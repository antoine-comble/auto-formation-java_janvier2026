package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesMakes10Test {

    @Test
    public void makes10_9_10() {
        Assertions.assertTrue(Exercises.makes10(9, 10));
    }

    @Test
    public void makes10_9_1() {
        Assertions.assertTrue(Exercises.makes10(9, 1));
    }

    @Test
    public void makes10_8_8() {
        Assertions.assertFalse(Exercises.makes10(8, 8));
    }
}
