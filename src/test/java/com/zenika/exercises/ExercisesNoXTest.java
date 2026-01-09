package test.com.zenika.exercises;

import main.com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExercisesNoXTest {

    @Test
    public void noX_xxax_xbxbx_xxcx_give_a_bb_c() {
        List<String> expected = new ArrayList<>();
        expected.add("a");
        expected.add("bb");
        expected.add("ccc");
        List<String> actual = new ArrayList<>();
        actual.add("xxax");
        actual.add("xbxbx");
        actual.add("xxcxxcxxc");
        Assertions.assertArrayEquals(expected.toArray(), Exercises.noX(actual).toArray());
    }
}
