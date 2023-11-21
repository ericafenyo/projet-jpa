package fr.diginamic.menu.action;

import fr.diginamic.di.ServiceLoader;
import fr.diginamic.menu.exception.EmptyInputException;
import fr.diginamic.persistence.dao.CastDao;
import fr.diginamic.persistence.entities.CastEntity;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the action to display the cast of a given movie.
 */
public class DisplayMovieCastsAction implements Action {

    private final Scanner scanner;

    public DisplayMovieCastsAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter an movie name:");

        String name = scanner.nextLine();
        if (!name.isBlank()) {
            execute(name);
        } else {
            throw new EmptyInputException();
        }
    }

    private void execute(String name) {
        List<CastEntity> casts = ServiceLoader.load(CastDao.class).findCastByMovie(name);

        if (casts.isEmpty()) {
            System.out.println("No casts found");
        }

        int counter = 1;
        for (CastEntity cast : casts) {
            System.out.printf("%d. %s%n", counter, cast.getName());
            counter++;
        }
    }

    @Override
    public String instructions() {
        return "Display the cast of a given film";
    }
}
