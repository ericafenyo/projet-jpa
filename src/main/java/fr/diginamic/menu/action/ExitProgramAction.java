package fr.diginamic.menu.action;

import java.util.Scanner;

public class ExitProgramAction implements Action {

    @Override
    public void execute() throws Exception {
        System.out.println("Exiting now...100%");
    }

    @Override
    public String instructions() {
        return "Exit the application.";
    }
}
