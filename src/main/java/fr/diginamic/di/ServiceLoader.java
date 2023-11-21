package fr.diginamic.di;

import fr.diginamic.persistence.dao.CastDao;
import fr.diginamic.persistence.dao.CountryDao;
import fr.diginamic.persistence.dao.DirectorDao;
import fr.diginamic.persistence.dao.GenreDao;
import fr.diginamic.persistence.dao.LanguageDao;
import fr.diginamic.persistence.dao.LocationDao;
import fr.diginamic.persistence.dao.MovieDao;
import fr.diginamic.persistence.dao.RoleDao;
import fr.diginamic.services.MovieService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Utility class to load implementations of services.
 */
public class ServiceLoader {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("database_config");
    private static final MovieService movieService = new MovieServiceImpl(new MovieDaoImpl());
    private static final CastDao castDao = new CastDaoImpl();
    private static final RoleDao roleDao = new RoleDaoImpl();
    private static final LanguageDao languageDao = new LanguageDaoImpl();
    private static final CountryDao countryDao = new CountryDaoImpl();
    private static final LocationDao locationDao = new LocationDaoImpl();
    private static final GenreDao genreDao = new GenreDaoImpl();
    private static final DirectorDao directorDao = new DirectorDaoImpl();
    private static final MovieDao movieDao = new MovieDaoImpl();

    /**
     * Loads an implementation of the specified service interface.
     *
     * @param service The service interface class.
     * @param <T>     The type of the service interface.
     * @return An instance implementing the service interface, or null if no implementation is found.
     */
    @SuppressWarnings("unchecked")
    public static <T> T load(Class<T> service) {
        if (service.equals(EntityManager.class)) {
            return (T) factory.createEntityManager(); // Actual loading logic needs to be implemented
        } else if (service.equals(MovieService.class)) {
            return (T) movieService;
        } else if (service.equals(CastDao.class)) {
            return (T) castDao;
        } else if (service.equals(RoleDao.class)) {
            return (T) roleDao;
        } else if (service.equals(LanguageDao.class)) {
            return (T) languageDao;
        } else if (service.equals(CountryDao.class)) {
            return (T) countryDao;
        } else if (service.equals(LocationDao.class)) {
            return (T) locationDao;
        } else if (service.equals(GenreDao.class)) {
            return (T) genreDao;
        } else if (service.equals(DirectorDao.class)) {
            return (T) directorDao;
        }else if (service.equals(MovieDao.class)) {
            return (T) movieDao;
        } else {
            throw new IllegalArgumentException("Invalid service class: " + service.getName());
        }
    }
}

