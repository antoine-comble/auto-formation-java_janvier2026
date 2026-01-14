package com.zenika.bibliotheque;

import java.util.Comparator;

public class DocumentComparator implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        return o1.getNumeroEnregistrement().compareTo(o2.getNumeroEnregistrement());
    }
}
