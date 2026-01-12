package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ExercisesMath1Test {

    static Stream<Arguments> math1_can_return_the_correct_value() {
        return Stream.of(
                Arguments.of(List.of(10), List.of(110)),
                Arguments.of(List.of(1, 2, 3, 4), List.of(20, 30, 40, 50))
        );
    }

    @ParameterizedTest
    @MethodSource
    void math1_can_return_the_correct_value(List<Integer> actual, List<Integer> expected) {
        org.assertj.core.api.Assertions.assertThat(Exercises.math1(actual))
                .describedAs(String.format("When entering (%s), we should return %s, no?", actual, expected))
                .isEqualTo(expected);
    }
}
