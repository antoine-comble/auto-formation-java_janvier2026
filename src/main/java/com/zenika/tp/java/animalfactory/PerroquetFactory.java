package com.zenika.tp.java.animalfactory;

public class PerroquetFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Perroquet();
    }
}
