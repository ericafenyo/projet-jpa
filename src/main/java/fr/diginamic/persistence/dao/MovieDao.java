package fr.diginamic.persistence.dao;

import fr.diginamic.model.Movie;
import fr.diginamic.persistence.entities.MovieEntity;

import java.util.List;

/**
 * A DAO (Data Access Object) interface defining operations for managing movies.
 */
public interface MovieDao {
    /**
     * Bulk inserts a collection of movies into the database.
     *
     * @param movies A collection of movies to be inserted.
     */
    void bulkInsert(Iterable<Movie> movies);

    /**
     * Keeps a record of errors related to products.
     *
     * @param errors A collection of failed entries.
     */
    void keepErrors(Iterable<String> errors);

    List<MovieEntity> fetchFilmographyByCast(String name);

    List<MovieEntity> fetchByYearRangeByActor(int firstYear, int secondYear, String name);

    List<MovieEntity> findMoviesBetweenYears(int startYear, int endYear);

    List<MovieEntity> findMoviesCommonToTwoCasts(String firstCast, String secondCast);
}
