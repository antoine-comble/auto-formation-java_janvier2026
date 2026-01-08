package main.com.zenika.tp.java.collection.common;

import main.com.zenika.tp.java.exception.MineurException.MineurException;

import java.io.Serializable;
import java.util.Objects;

public record PersonRecord(String firstName, String name, int age) implements Serializable {
    @Override
    public String toString() {
        return Objects.toString(firstName) + " " + Objects.toString(name) + " " + age;
    }
}
