package com.zenika.bibliotheque;

public class Revue extends Document {
    private int mois;
    private int annee;

    public Revue(String titre, String numeroEnregistrement, int mois, int annee) {
        super(titre, numeroEnregistrement);
        this.mois = mois;
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }
}
