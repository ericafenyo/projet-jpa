package fr.diginamic.persistence.dao;

import fr.diginamic.model.Cast;
import fr.diginamic.persistence.entities.CastEntity;

import java.util.List;

/**
 * A DAO (Data Access Object) interface specifically for handling operations related to movie casts.
 */
public interface CastDao extends IterableDao<Cast, CastEntity> {
    List<CastEntity> findCastInTwoMovies(String firstMovie, String secondMovie);

    List<CastEntity> findCastByMovie(String name);
}
