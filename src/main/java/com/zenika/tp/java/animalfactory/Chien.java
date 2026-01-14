package com.zenika.tp.java.animalfactory;

import java.util.logging.Logger;

public class Chien implements Animal {
    @Override
    public String adopter() {
        return "WOUAF";
    }
}
