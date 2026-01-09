package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesBunnyEars2Test {

    @Test
    public void bunnyEars2_0_give_0() {
        Assertions.assertEquals(0, Exercises.bunnyEars2(0));
    }

    @Test
    public void bunnyEars2_1_give_2() {
        Assertions.assertEquals(2, Exercises.bunnyEars2(1));
    }

    @Test
    public void bunnyEars2_2_give_5() {
        Assertions.assertEquals(5, Exercises.bunnyEars2(2));
    }

    @Test
    public void bunnyEars2_10_give_25() {
        Assertions.assertEquals(25, Exercises.bunnyEars2(10));
    }
 }
