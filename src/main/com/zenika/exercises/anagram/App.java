package main.com.zenika.exercises.anagram;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static main.com.zenika.exercises.anagram.Utils.anagramFrom;
import static main.com.zenika.exercises.anagram.Utils.readDictionary;

public class App {

    static void main(final String[] args) throws IOException, URISyntaxException {
        List<String> data = readDictionary();

        String anagram = anagramFrom(data);
        System.out.println("anagram = " + anagram);

        String result = decodeAnagram(anagram, data);
        System.out.println("result = " + result);
    }

    static String decodeAnagram(String anagram, List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            if (equalsIgnoreOrder(anagram, data.get(i))) {
                return data.get(i);
            }
        }
        throw new RuntimeException("Anagram " + anagram + " not found");
    }

    public static boolean equalsIgnoreOrder(String anagram, String word) {
        char[] anagramCharArray = anagram.toCharArray();
        char[] wordCharArray = word.toCharArray();

        Arrays.sort(anagramCharArray);
        Arrays.sort(wordCharArray);

        return Arrays.equals(anagramCharArray, wordCharArray);
    }
}
