package fr.diginamic.menu.exception;

/**
 * Base exception class for our menu application.
 */
public class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }
}
