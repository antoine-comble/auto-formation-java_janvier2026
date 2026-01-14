package com.zenika.tp.java.animalfactory;

public class ChienFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Chien();
    }
}
