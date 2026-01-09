package com.zenika.exercises;

import com.zenika.tp.java.Exercises;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ExercisesMakes10Test {
    static Stream<Arguments> makes10_can_return_the_correct_value() {
        return Stream.of(
            Arguments.of(9, 10, true),
            Arguments.of(9, 1, true),
            Arguments.of(8, 8, false),
            Arguments.of(9, 19, false)
        );
    }

    @ParameterizedTest @MethodSource 
    void makes10_can_return_the_correct_value(int first, int second, boolean expected) {
        Assertions.assertThat(Exercises.makes10(first, second))
            .describedAs(String.format("When entering %d and %d, we should return %s, no?", first, second, expected))
            .isEqualTo(expected);
    }
}
