package fr.diginamic.di;

import fr.diginamic.model.Cast;
import fr.diginamic.model.Director;
import fr.diginamic.model.Genre;
import fr.diginamic.model.Movie;
import fr.diginamic.persistence.dao.CastDao;
import fr.diginamic.persistence.dao.CountryDao;
import fr.diginamic.persistence.dao.DirectorDao;
import fr.diginamic.persistence.dao.GenreDao;
import fr.diginamic.persistence.dao.LanguageDao;
import fr.diginamic.persistence.dao.LocationDao;
import fr.diginamic.persistence.dao.MovieDao;
import fr.diginamic.persistence.dao.RoleDao;
import fr.diginamic.persistence.entities.CountryEntity;
import fr.diginamic.persistence.entities.LanguageEntity;
import fr.diginamic.persistence.entities.LocationEntity;
import fr.diginamic.persistence.entities.MovieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MovieDaoImpl implements MovieDao {

    @Override
    public void bulkInsert(Iterable<Movie> movies) {
        // Get an instance of entity manager
        EntityManager manager = ServiceLoader.load(EntityManager.class);

        // Set up database transaction
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        CountryDao countryDao = ServiceLoader.load(CountryDao.class);
        LanguageDao languageDao = ServiceLoader.load(LanguageDao.class);
        LocationDao locationDao = ServiceLoader.load(LocationDao.class);

        CastDao castDao = ServiceLoader.load(CastDao.class);
        RoleDao roleDao = ServiceLoader.load(RoleDao.class);
        GenreDao genreDao = ServiceLoader.load(GenreDao.class);
        DirectorDao directorDao = ServiceLoader.load(DirectorDao.class);

        for (Movie movie : movies) {
            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setName(movie.getName());
            movieEntity.setImdbId(movie.getImdbId());
            movieEntity.setPlot(movie.getPlot());
            movieEntity.setUrl(movie.getUrl());
            movieEntity.setYear(movie.getYear());
            movieEntity.setRating(movie.getRating());

            ExecutorService executor = Executors.newFixedThreadPool(10);

            List<Future<?>> futures = List.of(
                    // Insert countries
                    executor.submit(() -> {
                        CountryEntity countryEntity = countryDao.insert(movie.getCountry());
                        movieEntity.setCountry(countryEntity);
                    }),

                    // Insert languages
                    executor.submit(() -> {
                        LanguageEntity languageEntity = languageDao.insert(movie.getLanguage());
                        movieEntity.setLanguage(languageEntity);
                    }),

                    // Insert shooting location
                    executor.submit(() -> {
                        LocationEntity locationEntity = locationDao.insert(movie.getLocation());
                        movieEntity.setShootingLocation(locationEntity);
                    }),

                    // Insert genres
                    executor.submit(() -> {
                        genreDao.bulkInsert(movie.getGenres());
                    }),

                    // Insert casts
                    executor.submit(() -> {
                        castDao.bulkInsert(movie.getCasts());
                    }),

                    // Insert directors
                    executor.submit(() -> {
                        directorDao.bulkInsert(movie.getDirectors());
                    }),

                    // Insert roles
                    executor.submit(() -> {
                        roleDao.bulkInsert(movie.getRoles());
                    })
            );

            futures.forEach(future -> {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException exception) {
                    throw new RuntimeException(exception);
                }
            });
            executor.shutdown();

            List<String> castImdbIds = movie.getCasts().stream().map(Cast::getImdbId).toList();
            movieEntity.setCasts(castDao.findByProperties(castImdbIds, manager));

            List<String> genreNames = movie.getGenres().stream().map(Genre::getName).toList();
            movieEntity.setGenres(genreDao.findByProperties(genreNames, manager));

            List<String> directorImdbIds = movie.getDirectors().stream().map(Director::getImdbId).toList();
            movieEntity.setDirectors(directorDao.findByProperties(directorImdbIds, manager));

            manager.persist(movieEntity);
        }

        transaction.commit();
    }

    @Override
    public void keepErrors(Iterable<String> errors) {

    }

    @Override
    public List<MovieEntity> fetchFilmographyByCast(String name) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);

        String statement = "SELECT m FROM MovieEntity as m JOIN m.casts as c WHERE c.name=:name";
        return manager.createQuery(statement, MovieEntity.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<MovieEntity> fetchByYearRangeByActor(int startYear, int endYear, String name) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);

        String statement = "SELECT m FROM MovieEntity as m  JOIN m.casts as c WHERE m.year BETWEEN ?1 AND ?2 AND c.name=?3";
        return manager.createQuery(statement, MovieEntity.class)
                .setParameter(1, startYear)
                .setParameter(2, endYear)
                .setParameter(3, name)
                .getResultList();
    }

    @Override
    public List<MovieEntity> findMoviesBetweenYears(int startYear, int endYear) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);
        String statement = "SELECT m FROM MovieEntity as m WHERE m.year BETWEEN ?1 AND ?2";
        return manager.createQuery(statement, MovieEntity.class)
                .setParameter(1, startYear)
                .setParameter(2, endYear)
                .getResultList();
    }

    @Override
    public List<MovieEntity> findMoviesCommonToTwoCasts(String firstCast, String secondCast) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);
        String statement = "SELECT m FROM MovieEntity as m JOIN m.casts as c1 JOIN m.casts as c2 WHERE c1.name=?1 AND c2.name=?2";
        return manager.createQuery(statement, MovieEntity.class)
                .setParameter(1, firstCast)
                .setParameter(2, secondCast)
                .getResultList();
    }
}
