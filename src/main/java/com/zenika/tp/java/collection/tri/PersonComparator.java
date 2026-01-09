package com.zenika.tp.java.collection.tri;

import com.zenika.tp.java.collection.common.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().compareTo(o2.getName()) == 0) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
        return o1.getName().compareTo(o2.getName());
    }
}
