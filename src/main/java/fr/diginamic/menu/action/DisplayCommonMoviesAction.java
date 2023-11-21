package fr.diginamic.menu.action;

import fr.diginamic.di.ServiceLoader;
import fr.diginamic.persistence.dao.MovieDao;
import fr.diginamic.persistence.entities.MovieEntity;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the action to display movies common to two given actors/actresses.
 */
public class DisplayCommonMoviesAction implements Action {
    private final Scanner scanner;

    public DisplayCommonMoviesAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws Exception {
        // Retrieve the first actor or actress
        System.out.println("Enter the first actor/actress:");
        String firstCast = scanner.nextLine();

        // Retrieve the second actor or actress
        System.out.println("Enter the second actor/actress:");
        String secondCast = scanner.nextLine();

        execute(firstCast, secondCast);
    }

    private void execute(String firstCast, String secondCast) {
        List<MovieEntity> movies = ServiceLoader.load(MovieDao.class).findMoviesCommonToTwoCasts(firstCast, secondCast);

        if (movies.isEmpty()) {
            System.out.println("No movies found");
        }

        int counter = 1;
        for (MovieEntity movie : movies) {
            System.out.printf("%d. %s%n", counter, movie.getName());
            counter++;
        }
    }

    @Override
    public String instructions() {
        return "Display films common to two given actors/actresses.";
    }
}
