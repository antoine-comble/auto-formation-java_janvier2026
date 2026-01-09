package com.zenika.exercises.anagram;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utils {

    private static final Random RANDOM = new Random();

    public static String anagramFrom(List<String> data) {
        String randomData = data.get(RANDOM.nextInt(data.size()));
        return randomizeString(randomData);
    }

    private static String randomizeString(String randomData) {
        char[] chars = randomData.toCharArray();
        int length = chars.length;
        for (int i = 0; i < randomData.length() * 2; i++) {
            int i1 = RANDOM.nextInt(length);
            int i2 = RANDOM.nextInt(length);
            char a = chars[i1];
            chars[i1] = chars[i2];
            chars[i2] = a;
        }
        return new String(chars);
    }

    public static List<String> readDictionary() throws IOException {
        try(
            InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream("names.txt");
            Scanner s = new Scanner(inputStream).useDelimiter("\n")
            ) {
            // Source - https://stackoverflow.com/a/35446009
            // Posted by Slava Vedenin, modified by community. See post 'Timeline' for change history
            // Retrieved 2026-01-09, License - CC BY-SA 4.0

            return s.tokens().collect(Collectors.toList());
        }
    }
}

