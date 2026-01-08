package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesBunnyEarsTest {

    @Test
    public void bunnyEars_0_give_0() {
        Assertions.assertEquals(0, Exercises.bunnyEars(0));
    }

    @Test
    public void bunnyEars_1_give_2() {
        Assertions.assertEquals(2, Exercises.bunnyEars(1));
    }

    @Test
    public void bunnyEars_2_give_4() {
        Assertions.assertEquals(4, Exercises.bunnyEars(2));
    }

    @Test
    public void bunnyEars_50_give_100() {
        Assertions.assertEquals(100, Exercises.bunnyEars(50));
    }
}
