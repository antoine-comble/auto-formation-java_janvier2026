package com.zenika.tp.java.animalfactory;

public class ChatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Chat();
    }
}
