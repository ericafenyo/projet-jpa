package fr.diginamic.annotation;


import fr.diginamic.persistence.dao.MovieDao;

import java.util.Set;

public class ProvidesAnnotation {
    public static Set<Object> getElements() {
        return Set.of(MovieDao.class);
    }
}
