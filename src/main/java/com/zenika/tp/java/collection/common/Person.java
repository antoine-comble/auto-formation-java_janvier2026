package com.zenika.tp.java.collection.common;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private String firstName;

    public Person(String firstName, String name) {
        this.name = name;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return (((Person) o).getFirstName().equals(getFirstName()) && ((Person) o).getName().equals(getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getName());
    }

    @Override
    public int compareTo(Person o) {
        if (getName().compareTo(o.getName()) == 0) {
            return getFirstName().compareTo(o.getFirstName());
        }
        return getName().compareTo(o.getName());
    }
}
