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
 * Represents the action to display movies released between two given years.
 */
public class DisplayMoviesBetweenYearsAction implements Action {
    private final Scanner scanner;

    public DisplayMoviesBetweenYearsAction(Scanner scanner) {
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

        execute(startYear, endYear);
    }

    private void execute(int startYear, int endYear) {

        List<MovieEntity> movies =    ServiceLoader.load(MovieDao.class).findMoviesBetweenYears(startYear, endYear);

        if (movies.isEmpty()) {
            System.out.println("No movies found");
        }

        int counter = 1;
        for (MovieEntity movie : movies) {
            System.out.printf("%d. %s - %d%n", counter, movie.getName(), movie.getYear());
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
        return "Display films released between two given years.";
    }
}
