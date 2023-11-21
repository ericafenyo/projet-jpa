package fr.diginamic.menu.action;

/**
 * This interface represents a command to be executed.
 */
public interface Action  {
    /**
     * Executes the command, performing a specific action or operation.
     */
    void execute() throws Exception;

    /**
     *
     * Returns the instructions to follow to execute this action.
     */
    String instructions();
}