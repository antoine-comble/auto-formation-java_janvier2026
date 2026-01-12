package com.zenika.list;

import com.zenika.tp.java.collection.common.PersonRecord;
import com.zenika.tp.java.collection.list.MainList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainListTest {

    // Create dataset for tests
    protected static PersonRecord personRecord1 = new PersonRecord("Thomas", "Lefebvre", 23);
    protected static PersonRecord personRecord2 = new PersonRecord("Amélie", "Dubois", 13);
    protected static PersonRecord personRecord3 = new PersonRecord("Lucas", "Martin", 10);
    protected static PersonRecord personRecord4 = new PersonRecord("Sarah", "Rousseau", 42);
    protected static PersonRecord personRecord5 = new PersonRecord("Alexandre", "Petit", 56);
    protected static PersonRecord personRecord6 = new PersonRecord("Camille", "Bernard", 18);
    protected static PersonRecord personRecord7 = new PersonRecord("Maxime", "Durand", 17);
    protected static PersonRecord personRecord8 = new PersonRecord("Emma", "Moreau", 20);
    protected static PersonRecord personRecord9 = new PersonRecord("Nicolas", "Lambert", 94);
    protected static PersonRecord personRecord10 = new PersonRecord("Léa", "Fontaine", 66);
    protected static PersonRecord personRecord11 = new PersonRecord("Alexandre", "Petit", 56);
    protected static PersonRecord personRecord12 = new PersonRecord("Emma", "Bernard", 16);

    static List<PersonRecord> mineursList1 = List.of(personRecord2, personRecord3);
    static List<PersonRecord> mineursList2 = List.of(personRecord7, personRecord12);

    static List<PersonRecord> firstNameGt3Char = List.of(personRecord1, personRecord2, personRecord3, personRecord4, personRecord5, personRecord6, personRecord7, personRecord8, personRecord9, personRecord11, personRecord12);
    static List<PersonRecord> firstNameGt3CharSorted = List.of(personRecord11, personRecord5, personRecord2, personRecord6, personRecord12, personRecord8, personRecord3, personRecord7, personRecord9, personRecord4, personRecord1);

    static List<PersonRecord> personsList1 = List.of(personRecord1, personRecord2, personRecord3, personRecord4, personRecord5, personRecord6);
    static List<PersonRecord> personsList2 = List.of(personRecord7, personRecord8, personRecord9, personRecord10, personRecord11, personRecord12);
    static List<PersonRecord> persons = Stream.concat(personsList1.stream(), personsList2.stream()).collect(Collectors.toList());

    static Stream<Arguments> trouverLesMineurs_can_return_the_correct_value() {
        return Stream.of(
                Arguments.of(personsList1, mineursList1),
                Arguments.of(personsList2, mineursList2)
         );
    }

    static Stream<Arguments> trouverLesPersonnesAvecPrenomPlus4Lettres_can_return_the_correct_value() {
        return Stream.of(
                Arguments.of(persons, false, firstNameGt3Char),
                Arguments.of(persons, true, firstNameGt3CharSorted)
        );
    }

    @ParameterizedTest
    @MethodSource
    void trouverLesMineurs_can_return_the_correct_value(List<PersonRecord> actual, List<PersonRecord> expected) {
        Assertions.assertThat(MainList.trouverLesMineurs(actual))
                .describedAs(String.format("Considering these persons (%s), we should have only people : (%s), no?", actual, expected))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource
    void trouverLesPersonnesAvecPrenomPlus4Lettres_can_return_the_correct_value(List<PersonRecord> actual, boolean sortAlphabetic, List<PersonRecord> expected) {
        Assertions.assertThat(MainList.trouverLesPersonnesAvecPrenomPlus4Lettres(actual, sortAlphabetic))
                .describedAs(String.format("Considering these persons (%s), we should have only people : (%s), no?", actual, expected))
                .isEqualTo(expected);
    }
}
