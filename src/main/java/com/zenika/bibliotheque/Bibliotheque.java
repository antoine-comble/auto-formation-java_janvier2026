package com.zenika.bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private List<Document> documents = new ArrayList<Document>();

    /**
     *
     * @param document
     */
    public void ajouterDocument(final Document document) throws BookAlreadyExistsException {
        if (documents.contains(document)) throw new BookAlreadyExistsException(document.getTitre());
        documents.add(document);
    }

    /**
     *
     * @param document
     */
    public void ajouterDocumentEtTrieLaListe(final Document document) {
        this.ajouterDocument(document);
        List<Document> d = documents.stream().sorted().toList();
        documents.clear();
        documents.addAll(d);
    }

    /**
     *
     * @param index
     * @return
     */
    public Document getDocument(int index) {
        return documents.get(index);
    }

    /**
     *
     * @param document
     */
    public void supprimerDocument(final Document document) {
        documents = documents.stream().filter(d -> !d.equals(document)).toList();
    }

    /**
     *
     * @return
     */
    public List<Document> listerDocuments() {
        return documents;
    }
}
