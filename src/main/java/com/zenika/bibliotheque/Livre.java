package com.zenika.bibliotheque;

public class Livre extends Document {
    private String auteur;
    private int nbPages;

    public Livre(String titre, String numeroEnregistrement, String auteur, int nbPages) {
        super(titre, numeroEnregistrement);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    @Override
    public String toString() {
        return getTitre() + " " + getAuteur() + " " + getNumeroEnregistrement() + " " + getNbPages();
    }
}
