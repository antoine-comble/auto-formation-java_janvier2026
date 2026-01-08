package test.com.zenika;


import main.com.zenika.exercises.anagram.App;

import java.io.IOException;
import java.net.URISyntaxException;

import static main.com.zenika.exercises.anagram.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test
    void testDecodeAnagram() throws IOException, URISyntaxException {
        assertNotNull(App.decodeAnagram("Daraevttso", readDictionary()));
    }

    @org.junit.jupiter.api.Test
    void string_a_contains_a() throws IOException, URISyntaxException {
        assertTrue(App.equalsIgnoreOrder("a", "a"));
    }

    @org.junit.jupiter.api.Test
    void string_a_do_not_contains_b() throws IOException, URISyntaxException {
        assertFalse(App.equalsIgnoreOrder("a", "b"));
    }

    @org.junit.jupiter.api.Test
    void string_ab_is_anagram_a() throws IOException, URISyntaxException {
        assertFalse(App.equalsIgnoreOrder("a", "ab"));
    }

    @org.junit.jupiter.api.Test
    void string_aba_is_anagram_abb() throws IOException, URISyntaxException {
        assertFalse(App.equalsIgnoreOrder("aba", "abb"));
    }

    @org.junit.jupiter.api.Test
    void string_aba_is_anagram_aab() throws IOException, URISyntaxException {
        assertTrue(App.equalsIgnoreOrder("aba", "aab"));
    }

    @org.junit.jupiter.api.Test
    void string_aba_is_anagram_a_ab() throws IOException, URISyntaxException {
        assertFalse(App.equalsIgnoreOrder("abaaab", "a_ab?aba"));
    }

    @org.junit.jupiter.api.Test
    void string_endolori_is_anagram_indolore() throws IOException, URISyntaxException {
        assertTrue(App.equalsIgnoreOrder("endolori", "indolore"));
    }
}
