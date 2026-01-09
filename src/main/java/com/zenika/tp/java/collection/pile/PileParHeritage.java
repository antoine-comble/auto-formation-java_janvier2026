package com.zenika.tp.java.collection.pile;

import java.util.LinkedList;

public class PileParHeritage extends LinkedList implements Pile {

    @Override
    public Object depiler() {
        return removeLast();
    }

    @Override
    public void empiler(Object element) {
        addLast(element);
    }

    @Override
    public boolean estVide() {
        return isEmpty();
    }
}
