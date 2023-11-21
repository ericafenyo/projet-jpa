package fr.diginamic.menu.action;

import fr.diginamic.di.ServiceLoader;
import fr.diginamic.menu.exception.EmptyInputException;
import fr.diginamic.persistence.dao.CastDao;
import fr.diginamic.persistence.entities.CastEntity;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the action to display actors common to two given movies.
 */
public class DisplayCommonActorsInTwoMoviesAction implements Action {

    private final Scanner scanner;

    public DisplayCommonActorsInTwoMoviesAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws Exception {
        // Retrieve the first movie
        System.out.println("Enter the first movie:");
        String firstMovie = scanner.nextLine();
        if (firstMovie.isBlank()) {
            throw new EmptyInputException();
        }

        // Retrieve the second movie
        System.out.println("Enter the second movie:");
        String secondMovie = scanner.nextLine();
        if (secondMovie.isBlank()) {
            throw new EmptyInputException();
        }

        execute(firstMovie, secondMovie);

    }

    private void execute(String firstMovie, String secondMovie) {
        List<CastEntity> casts = ServiceLoader.load(CastDao.class).findCastInTwoMovies(firstMovie, secondMovie);
//         = CastsTwoMoviesInteractor.invoke(firstMovie, secondMovie);

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
        return "Display actors common to two given films.";
    }
}
