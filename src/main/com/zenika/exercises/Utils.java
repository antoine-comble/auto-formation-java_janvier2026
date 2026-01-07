package main.com.zenika.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

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

    static List<String> readDictionary() throws IOException {
        final Path path = Paths.get("C:\\Users\\Antoine\\Documents\\_dev\\FormationJava\\src\\main\\resources\\names.txt");
        return Files.readAllLines(path);
    }
}

