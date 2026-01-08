package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesPowerNTest {

    @Test
    void powerN_3_1_give_3() {
        Assertions.assertEquals(3, Exercises.powerN(3, 1));
    }

    @Test
    void powerN_3_2_give_9() {
        Assertions.assertEquals(9, Exercises.powerN(3, 2));
    }

    @Test
    void powerN_3_3_give_27() {
        Assertions.assertEquals(27, Exercises.powerN(3, 3));
    }

}
