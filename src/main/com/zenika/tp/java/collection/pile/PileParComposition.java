package main.com.zenika.tp.java.collection.pile;

import java.util.LinkedList;

public class PileParComposition implements Pile {

    private LinkedList internalList = new LinkedList();

    @Override
    public Object depiler() {
        return internalList.removeLast();
    }

    @Override
    public void empiler(Object element) {
        internalList.addLast(element);
    }

    @Override
    public boolean estVide() {
        return internalList.isEmpty();
    }
}
