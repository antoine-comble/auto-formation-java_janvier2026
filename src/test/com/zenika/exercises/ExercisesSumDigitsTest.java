package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesSumDigitsTest {

    @Test
    void sumDigits_126_give_9() {
        Assertions.assertEquals(9, Exercises.sumDigits(126));
    }

    @Test
    void sumDigits_49_give_13() {
        Assertions.assertEquals(13, Exercises.sumDigits(49));
    }

    @Test
    void sumDigits_11111_give_5() {
        Assertions.assertEquals(5, Exercises.sumDigits(11111));
    }
}
