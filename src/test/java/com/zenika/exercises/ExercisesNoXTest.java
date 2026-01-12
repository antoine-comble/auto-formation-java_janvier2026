package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExercisesNoXTest {

    static Stream<Arguments> noX_can_return_the_correct_value() {
        return Stream.of(
                Arguments.of(List.of("xxax", "xbxbx", "xxcxxcxxc"), List.of("a", "bb", "ccc"))
        );
    }

    @ParameterizedTest
    @MethodSource
    void noX_can_return_the_correct_value(List<String> actual, List<String> expected) {
        org.assertj.core.api.Assertions.assertThat(Exercises.noX(actual))
                .describedAs(String.format("When entering (%s), we should return %s, no?", actual, expected))
                .isEqualTo(expected);
    }
}
