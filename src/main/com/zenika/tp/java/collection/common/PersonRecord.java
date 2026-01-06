package main.com.zenika.tp.java.collection.common;

import main.com.zenika.tp.java.exception.MineurException.MineurException;

import java.io.Serializable;

public record PersonRecord(String firstName, String name, int age) implements Serializable {

}
