package fr.diginamic.menu.exception;

public class InvalidInputException extends ApplicationException {
    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException() {
        super("Input is invalid");
    }
}
