package fr.diginamic.services;

import fr.diginamic.model.Movie;

/**
 * A service object for handling movie-related operations.
 * <p>
 * This object is part of the domain layer so should not contact the database directly.
 */
public interface MovieService {
    /**
     * Saves a collection of movies.
     *
     * @param movies The collection of movies to be saved.
     */
    void save(Iterable<Movie> movies);

    /**
     * Generates a report for errors encountered during processing.
     *
     * @param errors The collection of error messages to be reported.
     */
    void report(Iterable<String> errors);
}
