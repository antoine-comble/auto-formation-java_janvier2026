package com.zenika.exercises;

import com.zenika.tp.java.Exercises;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExercisesDoublingTest {

    static Stream<Arguments> doubling_can_return_the_correct_value() {
        return Stream.of(
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(1), List.of(2)),
                Arguments.of(List.of(6, -3, 12, 23, 4, 1, 19, 11, 2, 3, 2), List.of(12, -6, 24, 46, 8, 2, 38, 22, 4, 6, 4)),
                Arguments.of(List.of(1, 2, 3), List.of(2, 4, 6))
        );
    }

    @ParameterizedTest
    @MethodSource
    void doubling_can_return_the_correct_value(List<Integer> actual, List<Integer> expected) {
        org.assertj.core.api.Assertions.assertThat(Exercises.doubling(actual))
                .describedAs(String.format("When entering (%s), we should return %s, no?", actual, expected))
                .isEqualTo(expected);
    }
}
