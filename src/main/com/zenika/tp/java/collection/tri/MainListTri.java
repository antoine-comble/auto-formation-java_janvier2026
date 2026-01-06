package main.com.zenika.tp.java.collection.tri;

import main.com.zenika.tp.java.collection.common.Person;
import main.com.zenika.tp.java.collection.list.MainList;

import java.util.List;

public class MainListTri {
    public static void main(String[] args) {
        System.out.println("-------------------");
        System.out.println("-- ORDRE D'AJOUT --");
        System.out.println("-------------------");
        List<Person> personList = MainList.createPersonList();
        personList.forEach(System.out::println);

        System.out.println("---------------------");
        System.out.println("-- AVEC COMPARATOR --");
        System.out.println("---------------------");
        PersonComparator personComparator = new PersonComparator();
        personList.sort(personComparator);
        personList.forEach(System.out::println);

        System.out.println("--------------------------");
        System.out.println("-- INTERFACE COMPARABLE --");
        System.out.println("--------------------------");
        personList = MainList.createPersonList();
        personList.stream().sorted().forEach(System.out::println);
    }
}
