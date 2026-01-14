package com.zenika.bibliotheque;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class BibliothequeTest {
    // Livre
    static Livre livre1 = new Livre("Le Petit Prince", "L001", "Antoine de Saint-Exupéry", 96);
    static Livre livre2 = new Livre("1984", "L002", "George Orwell", 328);
    static Livre livre3 = new Livre("L'Étranger", "L003", "Albert Camus", 184);
    static Livre livre4 = new Livre("Harry Potter à l'école des sorciers", "L004", "J.K. Rowling", 320);
    // ManuelScolaire
    static ManuelScolaire manuel1 = new ManuelScolaire("Mathématiques 6e", "MS001", "Hachette", 320, "6e", "Mathématiques");
    static ManuelScolaire manuel2 = new ManuelScolaire("Physique-Chimie 3e", "MS002", "Nathan", 280, "3e", "Physique-Chimie");
    static ManuelScolaire manuel3 = new ManuelScolaire("Histoire-Géographie Terminale", "MS003", "Belin", 400, "Terminale", "Histoire-Géographie");

    static List<Livre> bibliothequeWithOneBook = List.of(livre1);
    static List<Livre> bibliothequeWithTwoBooks = List.of(livre1, livre2);
    static List<Livre> bibliothequeWithTwoBooksUnordered = List.of(livre2, livre1);
    static List<Livre> bibliothequeComplete = List.of(livre2, livre4, livre3, livre1);

    static Stream<Arguments> ajouterDocument_can_return_the_correct_value() {
        return Stream.of(Arguments.of(livre1, bibliothequeWithOneBook));
    }

    static Stream<Arguments> ajouterDeuxDocumentx_can_return_the_correct_value() {
        return Stream.of(Arguments.of(List.of(livre1, livre2), bibliothequeWithTwoBooks));
    }

    static Stream<Arguments> ajouterDeuxDocumentxNoTries_can_return_the_correct_value() {
        return Stream.of(Arguments.of(List.of(livre1, livre2), bibliothequeWithTwoBooksUnordered));
    }

    static Stream<Arguments> supprimerDocument_can_return_the_correct_value() {
        return Stream.of(Arguments.of(List.of(livre1, livre2), bibliothequeWithOneBook));
    }


    static Stream<Arguments> ajouterDeuxDocumentxTries_can_return_the_correct_value() {
        return Stream.of(Arguments.of(List.of(livre1, livre2), bibliothequeWithTwoBooksUnordered));
    }

    static Stream<Arguments> bibliothequeCompleteTriee_can_return_the_correct_value() {
        return Stream.of(Arguments.of(List.of(livre1, livre2, livre3, livre4), bibliothequeComplete));
    }

    static Stream<Arguments> ajouterDeuxFoisMemeDocument_can_return_the_correct_value() {
        return Stream.of(Arguments.of(List.of(livre1, livre1)));
    }

    static Stream<Arguments>  getDocumentAtIndex_can_return_the_correct_value() {
        return Stream.of(
                Arguments.of(List.of(livre1, livre2, livre3, livre4), 3, livre1),
                Arguments.of(List.of(livre1, livre2, livre3, livre4), 0, livre2),
                Arguments.of(List.of(livre1, livre2, livre3, livre4), 1, livre4),
                Arguments.of(List.of(livre1, livre2, livre3, livre4), 2, livre3)
        );
    }

    @ParameterizedTest
    @MethodSource
    void ajouterDocument_can_return_the_correct_value(Document livre1, List<Document> bibliotheque) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        bibliotheque1.ajouterDocument(livre1);
        Assertions.assertThat(bibliotheque1.listerDocuments()).describedAs(String.format("When entering %s, we should return %s, no?", livre1, bibliotheque)).isEqualTo(bibliotheque);
    }

    @ParameterizedTest
    @MethodSource
    void ajouterDeuxDocumentx_can_return_the_correct_value(List<Document> livres, List<Document> bibliotheque) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        bibliotheque1.listerDocuments().addAll(livres);
        Assertions.assertThat(bibliotheque1.listerDocuments()).describedAs(String.format("When entering %s, we should return %s, no?", livres, bibliotheque)).isEqualTo(bibliotheque);
    }

    @ParameterizedTest
    @MethodSource
    void ajouterDeuxDocumentxNoTries_can_return_the_correct_value(List<Document> livres, List<Document> bibliotheque) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        bibliotheque1.listerDocuments().addAll(livres);
        Assertions.assertThat(bibliotheque1.listerDocuments().stream().sorted()).describedAs(String.format("When entering %s, we should return %s, no?", livres, bibliotheque)).isEqualTo(bibliotheque);
    }

    @ParameterizedTest
    @MethodSource
    void ajouterDeuxDocumentxTries_can_return_the_correct_value(List<Document> livres, List<Document> bibliotheque) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        for (Document livre : livres) {
            bibliotheque1.ajouterDocumentEtTrieLaListe(livre);
        }
        Assertions.assertThat(bibliotheque1.listerDocuments()).describedAs(String.format("When entering %s, we should return %s, no?", bibliotheque1, bibliotheque)).isEqualTo(bibliotheque);
    }

    @ParameterizedTest
    @MethodSource
    void supprimerDocument_can_return_the_correct_value(List<Document> livres, List<Document> bibliotheque) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        for (Document livre : livres) {
            bibliotheque1.ajouterDocument(livre);
        }
        bibliotheque1.supprimerDocument(livre2);
        Assertions.assertThat(bibliotheque1.listerDocuments()).describedAs(String.format("When entering %s, we should return %s, no?", livres, bibliotheque)).isEqualTo(bibliotheque);
    }

    @ParameterizedTest
    @MethodSource
    void bibliothequeCompleteTriee_can_return_the_correct_value(List<Document> livres, List<Document> bibliotheque) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        for (Document livre : livres) {
            bibliotheque1.ajouterDocumentEtTrieLaListe(livre);
        }
        Assertions.assertThat(bibliotheque1.listerDocuments()).describedAs(String.format("When entering %s, we should return %s, no?", livres, bibliotheque)).isEqualTo(bibliotheque);
    }

    @ParameterizedTest
    @MethodSource
    void ajouterDeuxFoisMemeDocument_can_return_the_correct_value(List<Document> livres) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        Assertions.assertThatThrownBy(() -> {
            bibliotheque1.ajouterDocument(livres.get(0));
            bibliotheque1.ajouterDocument(livres.get(1));
        }).isInstanceOf(BookAlreadyExistsException.class);
    }

    @ParameterizedTest
    @MethodSource
    void getDocumentAtIndex_can_return_the_correct_value(List<Document> livres, int index, Document expected) {
        Bibliotheque bibliotheque1 = new Bibliotheque();
        for (Document livre : livres) {
            bibliotheque1.ajouterDocumentEtTrieLaListe(livre);
        }
        Assertions.assertThat(bibliotheque1.getDocument(index).getTitre()).describedAs(String.format("When entering %s and %d, we should return %s, no?", livres, index, expected)).isEqualTo(expected.getTitre());
    }

}
