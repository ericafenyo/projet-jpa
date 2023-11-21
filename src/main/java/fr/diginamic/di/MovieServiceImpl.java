package fr.diginamic.di;

import fr.diginamic.model.Movie;
import fr.diginamic.persistence.dao.MovieDao;
import fr.diginamic.services.MovieService;

class MovieServiceImpl implements MovieService {

    private final MovieDao dao;

    public MovieServiceImpl(MovieDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Iterable<Movie> movies) {
        dao.bulkInsert(movies);
    }

    @Override
    public void report(Iterable<String> errors) {
        dao.keepErrors(errors);
    }
}
