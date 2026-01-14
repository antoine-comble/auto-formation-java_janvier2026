package com.zenika.animalfactory;

import com.zenika.tp.java.Exercises;
import com.zenika.tp.java.animalfactory.Animal;
import com.zenika.tp.java.animalfactory.ChienFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChienFactoryTest {

    @Test
    void createAnimal_using_createAnimal() {
        ChienFactory  chienFactory = new ChienFactory();
        Animal animal = chienFactory.createAnimal();
        Assertions.assertEquals("WOUAF", animal.adopter());
    }

    @Test
    void createAnimal_using_create() {
        ChienFactory  chienFactory = new ChienFactory();
        Animal animal = chienFactory.create();
        Assertions.assertEquals("WOUAF", animal.adopter());
    }
}