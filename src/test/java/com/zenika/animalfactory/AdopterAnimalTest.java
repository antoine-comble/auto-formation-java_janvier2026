package com.zenika.animalfactory;

import com.zenika.tp.java.animalfactory.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AdopterAnimalTest {

    static Animal chat1 = new ChatFactory().create();
    static Animal chat2 = new ChatFactory().create();
    static Animal chien1 = new ChienFactory().create();
    static Animal chien2 = new ChienFactory().create();

    static Stream<Arguments> adopter_can_return_the_correct_value() {
        return Stream.of(
                Arguments.of(chat1, "MIAOU"),
                Arguments.of(chat2, "MIAOU"),
                Arguments.of(chien1, "WOUAF"),
                Arguments.of(chien2, "WOUAF"),
                Arguments.of(new PerroquetFactory().create(), "Polly want a cracker !")
        );
    }

    @ParameterizedTest
    @MethodSource
    void adopter_can_return_the_correct_value(Animal actual, String expected) {
        org.assertj.core.api.Assertions.assertThat(AnimalFactory.adopter(actual))
                .describedAs(String.format("When entering (%s), we should return %s, no?", actual, expected))
                .isEqualTo(expected);
    }

}
