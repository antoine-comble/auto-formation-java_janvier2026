package main.com.zenika.tp.java.collection.list;

import main.com.zenika.tp.java.collection.common.Person;
import main.com.zenika.tp.java.collection.common.PersonRecord;
import main.com.zenika.tp.java.exception.MineurException.MineurException;

import java.util.*;

public class MainList {

    protected static PersonRecord personRecord1 = new PersonRecord("Thomas","Lefebvre", 23);
    protected static PersonRecord personRecord2 = new PersonRecord("Amélie","Dubois", 13);
    protected static PersonRecord personRecord3 = new PersonRecord("Lucas","Martin", 10);
    protected static PersonRecord personRecord4 = new PersonRecord("Sarah","Rousseau", 42);
    protected static PersonRecord personRecord5 = new PersonRecord("Alexandre","Petit", 56);
    protected static PersonRecord personRecord6 = new PersonRecord("Camille","Bernard", 18);
    protected static PersonRecord personRecord7 = new PersonRecord("Maxime","Durand", 17);
    protected static PersonRecord personRecord8 = new PersonRecord("Emma","Moreau", 20);
    protected static PersonRecord personRecord9 = new PersonRecord("Nicolas","Lambert", 94);
    protected static PersonRecord personRecord10 = new PersonRecord("Léa","Fontaine", 66);
    protected static PersonRecord personRecord11 = new PersonRecord("Alexandre","Petit", 56);
    protected static PersonRecord personRecord12 = new PersonRecord("Emma","Bernard", 16);

    protected static Person person1 = new Person("Thomas","Lefebvre");
    protected static Person person2 = new Person("Amélie","Dubois");
    protected static Person person3 = new Person("Lucas","Martin");
    protected static Person person4 = new Person("Sarah","Rousseau");
    protected static Person person5 = new Person("Alexandre","Petit");
    protected static Person person6 = new Person("Camille","Bernard");
    protected static Person person7 = new Person("Maxime","Durand");
    protected static Person person8 = new Person("Emma","Moreau");
    protected static Person person9 = new Person("Nicolas","Lambert");
    protected static Person person10 = new Person("Léa","Fontaine");
    protected static Person person11 = new Person("Alexandre","Petit");
    protected static Person person12 = new Person("Emma","Bernard");


    public static List<PersonRecord> createPersonRecordList() {
        final List<PersonRecord> personRecords = new ArrayList<>();
        personRecords.addLast(personRecord1);
        personRecords.addLast(personRecord2);
        personRecords.addLast(personRecord3);
        personRecords.addLast(personRecord4);
        personRecords.addLast(personRecord5);
        personRecords.addLast(personRecord6);
        personRecords.addLast(personRecord7);
        personRecords.addLast(personRecord8);
        personRecords.addLast(personRecord9);
        personRecords.addLast(personRecord10);
        personRecords.addLast(personRecord11);
        personRecords.addLast(personRecord12);
        return personRecords;
    }

    public static List<Person> createPersonList() {
        final List<Person> persons = new ArrayList<>();
        persons.addLast(person1);
        persons.addLast(person2);
        persons.addLast(person3);
        persons.addLast(person4);
        persons.addLast(person5);
        persons.addLast(person6);
        persons.addLast(person7);
        persons.addLast(person8);
        persons.addLast(person9);
        persons.addLast(person10);
        persons.addLast(person11);
        persons.addLast(person12);
        return persons;
    }

    public static HashSet<Person> createPersonSet() {
        final HashSet<Person> persons = new HashSet<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);
        persons.add(person9);
        persons.add(person10);
        persons.add(person11);
        persons.add(person12);
        return persons;
    }

    public static TreeSet<Person> createPersonTreeSet() {
        final TreeSet<Person> persons = new TreeSet<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);
        persons.add(person9);
        persons.add(person10);
        persons.add(person11);
        persons.add(person12);
        return persons;
    }

    static void main() {

        System.out.println("-----");

        // List iterator
        final Iterator<Person> iterator = createPersonList().iterator();
        iterator.forEachRemaining(System.out::println);

        System.out.println("-- List triée --");
        createPersonList().stream().sorted().forEach(System.out::println);

        System.out.println("-- Set trié --");
        createPersonSet().forEach(System.out::println);

        System.out.println("-- TreeSet --");
        createPersonTreeSet().forEach(System.out::println);


        // stream
        createPersonRecordList().stream()
                .forEach(person ->
                        System.out.println(person.firstName() + " " + person.name())
                );

        System.out.println("");
        System.out.println("Suppression des doublons (prénom et nom égaux)");
        System.out.println("");
        System.out.println("Suppression des prénoms de moins de 4 lettres et tri par ordre alphabétique prénom");
        createPersonRecordList().stream()
                .distinct()
                .filter(person -> person.firstName().length() > 3)
                .sorted(Comparator.comparing(PersonRecord::firstName))
                .forEach(person ->
                        System.out.println(person.firstName() + " " + person.name())
                );

        System.out.println("");
        System.out.println("Suppression des prénoms de moins de 4 lettres et tri par ordre Z à A prénom");
        createPersonRecordList().stream()
                .distinct()
                .filter(person -> person.firstName().length() > 3)
                .sorted(Comparator.comparing(PersonRecord::firstName).reversed())
                .forEach(person ->
                        System.out.println(person.firstName() + " " + person.name())
                );

        System.out.println("");
        System.out.println("Suppression des prénoms de moins de 4 lettres et tri par ordre alphabétique prénom puis nom");
        createPersonRecordList().stream()
                .distinct()
                .filter(person -> person.firstName().length() > 3)
                .sorted(Comparator.comparing(PersonRecord::firstName).thenComparing(Comparator.comparing(PersonRecord::name)))
                .forEach(person ->
                        System.out.println(person.firstName() + " " + person.name())
                );

        System.out.println("");
        System.out.println("Suppression des prénoms de moins de 4 lettres et tri par ordre alphabétique prénom puis Z à A nom");
        createPersonRecordList().stream()
                .distinct()
                .filter(person -> person.firstName().length() > 3)
                .sorted(Comparator.comparing(PersonRecord::firstName).thenComparing(Comparator.comparing(PersonRecord::name).reversed()))
                .forEach(person ->
                        System.out.println(person.firstName() + " " + person.name())
                );

        System.out.println("");
        System.out.println("Suppression des prénoms de moins de 4 lettres et tri par ordre Z à A prénom puis Z à A nom");
        createPersonRecordList().stream()
                .distinct()
                .filter(person -> person.firstName().length() > 3)
                .sorted(Comparator.comparing(PersonRecord::firstName).reversed().thenComparing(Comparator.comparing(PersonRecord::name).reversed()))
                .forEach(person ->
                        System.out.println(person.firstName() + " " + person.name())
                );

        System.out.println("");
        System.out.println("Personnes majeures : ");
        final List<PersonRecord> personnesMineures = new ArrayList<>();
        createPersonRecordList().stream()
                .distinct()
                .forEach(person ->
                        {
                            try {
                                estMineur(person);
                                System.out.println(person.firstName() + " " + person.name() + " " + person.age());
                            } catch (MineurException e) {
                                personnesMineures.addLast(new PersonRecord(person.firstName(), person.name(), person.age()));
                            }
                        }
                );

        System.out.println("");
        System.out.println("Personnes mineures : ");
        personnesMineures.forEach(person -> System.out.println(person.firstName() + " " + person.name() + " " + person.age()));

    }

    static void estMineur(PersonRecord person) throws MineurException {
        if (person.age() < 18) {
            throw new MineurException();
        }
    }
}
