package fr.diginamic.menu.exception;

public class EmptyInputException extends ApplicationException {
    public EmptyInputException() {
        super("Input should not be empty");
    }
}
