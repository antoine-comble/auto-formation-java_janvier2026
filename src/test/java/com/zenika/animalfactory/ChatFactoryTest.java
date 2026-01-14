package com.zenika.animalfactory;

import com.zenika.tp.java.animalfactory.Animal;
import com.zenika.tp.java.animalfactory.ChatFactory;
import com.zenika.tp.java.animalfactory.ChienFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChatFactoryTest {

    @Test
    void createAnimal() {
        ChatFactory chatFactory = new ChatFactory();
        Animal animal = chatFactory.createAnimal();
        Assertions.assertEquals("MIAOU", animal.adopter());
    }
}