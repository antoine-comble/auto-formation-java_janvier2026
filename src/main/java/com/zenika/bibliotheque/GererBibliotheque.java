package com.zenika.bibliotheque;

import com.zenika.tp.java.collection.common.PersonRecord;

import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GererBibliotheque {

    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();

        Livre livre1 = new Livre("Le Petit Prince", "L001", "Antoine de Saint-Exupéry", 96);
        Livre livre2 = new Livre("1984", "L002", "George Orwell", 328);
        Livre livre3 = new Livre("L'Étranger", "L003", "Albert Camus", 184);
        Livre livre4 = new Livre("Harry Potter à l'école des sorciers", "L004", "J.K. Rowling", 320);

        ManuelScolaire manuel1 = new ManuelScolaire("Mathématiques 6e", "MS001", "Hachette", 320, "6e", "Mathématiques");
        ManuelScolaire manuel2 = new ManuelScolaire("Physique-Chimie 3e", "MS002", "Nathan", 280, "3e", "Physique-Chimie");
        ManuelScolaire manuel3 = new ManuelScolaire("Histoire-Géographie Terminale", "MS003", "Belin", 400, "Terminale", "Histoire-Géographie");
        ManuelScolaire manuel5 = new ManuelScolaire("Mathématiques 4e", "MS004", "Hachette", 345, "4e", "Mathématiques");

        bibliotheque.ajouterDocument(livre1);
        bibliotheque.ajouterDocument(livre2);
        bibliotheque.ajouterDocument(livre3);
        bibliotheque.ajouterDocument(livre4);
        bibliotheque.ajouterDocument(manuel1);
        bibliotheque.ajouterDocument(manuel2);
        bibliotheque.ajouterDocument(manuel3);
        bibliotheque.ajouterDocument(manuel5);

        Logger.getAnonymousLogger().info(
                bibliotheque.listerDocuments()
                        .stream()
                        .map(Document::toString)
                        .collect(Collectors.joining(","))
        );

        Logger.getAnonymousLogger().info(
                bibliotheque.listerDocuments()
                        .stream()
                        .filter(d -> d instanceof ManuelScolaire)
                        .map(d -> (ManuelScolaire) d)
                        .filter(ms -> ms.getMatiere().equals("Mathématiques"))
                        .map(Document::toString).collect(Collectors.joining(","))
        );

        Logger.getAnonymousLogger().info(
                bibliotheque.listerDocuments()
                        .stream()
                        .filter(ManuelScolaire.class::isInstance)
                        .map(ManuelScolaire.class::cast)
                        .filter(ms -> ms.getMatiere().equals("Mathématiques"))
                        .map(Document::toString).collect(Collectors.joining(","))
        );
    }

}
