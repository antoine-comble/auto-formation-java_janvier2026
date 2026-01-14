package com.zenika.tp.java.animalfactory;

import java.util.logging.Logger;

public class Chat implements Animal {
    @Override
    public String adopter() {
        return "MIAOU";
    }
}
