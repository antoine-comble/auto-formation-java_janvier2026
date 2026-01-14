package com.zenika.bibliotheque;

public class ManuelScolaire extends Livre {
    private String niveau;
    private String matiere;

    public ManuelScolaire(String titre, String numeroEnregistrement, String auteur, int nbPages, String niveau, String matiere) {
        super(titre, numeroEnregistrement, auteur, nbPages);
        this.niveau = niveau;
        this.matiere = matiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getMatiere() {
        return matiere;
    }

}
