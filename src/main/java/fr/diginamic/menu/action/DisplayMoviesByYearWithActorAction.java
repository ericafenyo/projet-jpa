package fr.diginamic.menu.action;

import fr.diginamic.di.ServiceLoader;
import fr.diginamic.menu.exception.EmptyInputException;
import fr.diginamic.menu.exception.InvalidInputException;
import fr.diginamic.persistence.dao.MovieDao;
import fr.diginamic.persistence.entities.MovieEntity;
import fr.diginamic.util.Numbers;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the action to display films released between two
 * given years that feature a given actor/actress in the cast.
 */
public class DisplayMoviesByYearWithActorAction implements Action {
    private final Scanner scanner;

    public DisplayMoviesByYearWithActorAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws Exception {
        // Retrieve the starting year
        System.out.println("Enter the starting year:");
        String startYearInput = scanner.nextLine();
        int startYear = parseInput(startYearInput);

        // Retrieve the starting year
        System.out.println("Enter the ending year:");
        String endYearInput = scanner.nextLine();
        int endYear = parseInput(endYearInput);

        if (startYear > endYear) {
            throw new InvalidInputException("Starting year should not be greater than the ending year");
        }

        System.out.println("Enter an actor/actress:");
        String name = scanner.nextLine();

        if (name.isBlank()) {
            throw new EmptyInputException();
        }

        execute(startYear, endYear, name);
    }

    private void execute(int firstYear, int secondYear, String name) {
        List<MovieEntity> movies =
                ServiceLoader.load(MovieDao.class).fetchByYearRangeByActor(firstYear, secondYear, name);

        if (movies.isEmpty()) {
            System.out.println("No movies found");
        }

        int counter = 1;
        for (MovieEntity movie : movies) {
            System.out.printf("%d. %s%n", counter, movie.getName());
            counter++;
        }
    }

    private static int parseInput(String yearInput) throws EmptyInputException, InvalidInputException {
        // Check if the input is not empty
        if (yearInput.isBlank()) {
            throw new EmptyInputException();
        }

        // Check if the input is valid year
        if (!Numbers.isNumeric(yearInput)) {
            throw new InvalidInputException("Invalid year input");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
            TemporalAccessor accessor = formatter.parse(yearInput);
            return accessor.get(ChronoField.YEAR);
        } catch (DateTimeException exception) {
            throw new InvalidInputException("Invalid year input: \n" + exception.getMessage());
        }
    }

    @Override
    public String instructions() {
        return "Display films released between two given years that feature a given actor/actress in the cast.";
    }
}
