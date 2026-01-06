package main.com.zenika.tp.java.io;

import main.com.zenika.tp.java.collection.common.PersonRecord;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFileWriter {

    static void main(String[] args) {
        PersonRecord personRecord = new PersonRecord("John", "Wayne", 45);
        String filePath = "C:\\Users\\Antoine\\Documents\\_dev\\FormationJava\\out\\production\\FormationJava\\main\\com\\zenika\\tp\\java\\io\\person.txt";
        Path path = Paths.get(filePath);
        // Ecriture
        try {
            Files.writeString(path, personRecord.firstName() + "," + personRecord.name() + "," + personRecord.age());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Lecture
        try {
            String content = Files.readString(path);
            System.out.println("Contenu du fichier : " + content);
            String[] tokens = content.split(",");
            PersonRecord personRecord1 = new PersonRecord(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            System.out.println(personRecord1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
