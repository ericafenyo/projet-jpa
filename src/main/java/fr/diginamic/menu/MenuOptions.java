package fr.diginamic.menu;

import fr.diginamic.menu.action.Action;
import fr.diginamic.menu.action.DisplayActorFilmographyAction;
import fr.diginamic.menu.action.DisplayCommonActorsInTwoMoviesAction;
import fr.diginamic.menu.action.DisplayCommonMoviesAction;
import fr.diginamic.menu.action.DisplayMovieCastsAction;
import fr.diginamic.menu.action.DisplayMoviesBetweenYearsAction;
import fr.diginamic.menu.action.DisplayMoviesByYearWithActorAction;
import fr.diginamic.menu.action.ExitProgramAction;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static fr.diginamic.util.Numbers.isInteger;
import static fr.diginamic.util.Numbers.withinRange;

/**
 * General menu with option to query the movie database.
 */
public class MenuOptions {
    // We will maintain the order of the actions as they are added.
    private static final List<Action> actions = new LinkedList<>();

    private MenuOptions() { }

    // Displays the menu options
    public static void display() throws Exception {
        Scanner scanner = new Scanner(System.in);

        bindOptions(scanner);

        // Display the options
        AtomicInteger bullet = new AtomicInteger(1);
        actions.forEach(action -> {
            System.out.printf("%d. %s%n", bullet.getAndIncrement(), action.instructions());
        });

        System.out.println("\nSelect a valid option:");

        int option;
        while (true) {
            String input = scanner.nextLine();
            System.out.println(input);
            if (isInteger(input) && withinRange(Integer.parseInt(input), 1, actions.size())) {
                option = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Select a valid option:");
            }
        }

        // Retrieve and execute the correct and  it.
        int index = option - 1;
        var command = actions.get(index);
        if (command != null) {
            command.execute();
        }
    }

    // Add actions to the list.
    private static void bindOptions(Scanner scanner) {
        actions.add(new DisplayActorFilmographyAction(scanner));
        actions.add(new DisplayMovieCastsAction(scanner));
        actions.add(new DisplayMoviesBetweenYearsAction(scanner));
        actions.add(new DisplayCommonMoviesAction(scanner));
        actions.add(new DisplayCommonActorsInTwoMoviesAction(scanner));
        actions.add(new DisplayMoviesByYearWithActorAction(scanner));
        actions.add(new ExitProgramAction());
    }
}
