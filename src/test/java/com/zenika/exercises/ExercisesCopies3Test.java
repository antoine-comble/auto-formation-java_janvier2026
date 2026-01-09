package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExercisesCopies3Test {

    @Test
    public void copies3_test_give_testtesttest() {
        List<String> expected = new ArrayList<>();
        expected.add("testtesttest");
        List<String> actual = new ArrayList<>();
        actual.add("test");
        Assertions.assertArrayEquals(expected.toArray(), Exercises.copies3(actual).toArray());
    }

    @Test
    public void copies3_hello_there_give_hellohellohello_theretherethere() {
        List<String> expected = new ArrayList<>();
        expected.add("hellohellohello");
        expected.add("theretherethere");
        List<String> actual = new ArrayList<>();
        actual.add("hello");
        actual.add("there");
        Assertions.assertArrayEquals(expected.toArray(), Exercises.copies3(actual).toArray());
    }
}
