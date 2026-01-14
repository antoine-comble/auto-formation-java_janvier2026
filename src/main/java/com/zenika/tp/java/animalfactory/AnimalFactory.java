package com.zenika.tp.java.animalfactory;

public abstract class AnimalFactory {
    public Animal create() {
        return createAnimal();
    }

    protected abstract Animal createAnimal();

    public static String adopter(Animal animal) {
        return animal.adopter();
    }
}
