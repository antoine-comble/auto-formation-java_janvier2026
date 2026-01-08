package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesCountXTest {

    @Test
    void countX_hi_give_0() {
        Assertions.assertEquals(0, Exercises.countX("hi"));
    }

    @Test
    void countX_x_give_1() {
        Assertions.assertEquals(1, Exercises.countX("x"));
    }

    @Test
    void countX_xxhixx_give_4() {
        Assertions.assertEquals(4, Exercises.countX("xxhixx"));
    }

    @Test
    void countX_xhixhix_give_3() {
        Assertions.assertEquals(3, Exercises.countX("xhixhix"));
    }

}
