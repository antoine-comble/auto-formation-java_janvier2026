package main.com.zenika.tp.java.io;

import main.com.zenika.tp.java.collection.common.PersonRecord;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainIO {

    static String filePath = "C:\\Users\\Antoine\\Documents\\_dev\\FormationJava\\out\\production\\FormationJava\\main\\com\\zenika\\tp\\java\\io\\person.ser";

    static void main(String[] args) {
        writePerson();
        readPerson();
    }

    static void writePerson() {
        PersonRecord personRecord = new PersonRecord("John", "Doe", 25);

        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(personRecord);
            oos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readPerson() {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            PersonRecord person = (PersonRecord) ois.readObject();
            System.out.println(person.firstName() + " " + person.name() + " " + person.age());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
