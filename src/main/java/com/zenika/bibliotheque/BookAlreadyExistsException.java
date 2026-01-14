package com.zenika.bibliotheque;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String titre) {
        Logger.getLogger(BookAlreadyExistsException.class.getName()).log(Level.INFO, "BookAlreadyExistsException", titre);
    }
}
