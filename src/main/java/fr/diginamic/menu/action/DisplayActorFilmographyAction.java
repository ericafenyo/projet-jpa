package fr.diginamic.menu.action;

import fr.diginamic.di.ServiceLoader;
import fr.diginamic.menu.exception.EmptyInputException;
import fr.diginamic.persistence.dao.MovieDao;
import fr.diginamic.persistence.entities.MovieEntity;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the action to display the filmography of a given actor.
 */
public class DisplayActorFilmographyAction implements Action {

    private final Scanner scanner;

    public DisplayActorFilmographyAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter an actor/actress:");

        String name = scanner.nextLine();
        if (!name.isBlank()) {
            execute(name);
        } else {
            throw new EmptyInputException();
        }
    }

    private void execute(String name) {
        // Load movies from the database.
        List<MovieEntity> movies = ServiceLoader.load(MovieDao.class).fetchFilmographyByCast(name);

        if (movies.isEmpty()) {
            System.out.println("No filmography found");
        }

        int counter = 1;
        for (MovieEntity movie : movies) {
            System.out.printf("%d. %s%n", counter, movie.getName());
            counter++;
        }
    }

    @Override
    public String instructions() {
        return "Display the filmography of a given actor/actress.";
    }
}
