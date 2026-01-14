package com.zenika.bibliotheque;

import com.zenika.tp.java.Exercises;

public class Document implements Comparable {
    private String titre;
    private String numeroEnregistrement;

    public Document(String titre, String numeroEnregistrement) {
        this.titre = titre;
        this.numeroEnregistrement = numeroEnregistrement;
    }

    public String getTitre() {
        return titre;
    }

    public String getNumeroEnregistrement() {
        return numeroEnregistrement;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Document document)) return false;
        return (this.titre.equals(document.titre));
    }

    @Override
    public String toString() {
        return titre + " " + numeroEnregistrement;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Document)) return -1;
        return this.titre.compareTo(((Document) o).titre);
    }
}
