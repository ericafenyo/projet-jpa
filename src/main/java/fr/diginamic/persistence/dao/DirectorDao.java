package fr.diginamic.persistence.dao;

import fr.diginamic.model.Cast;
import fr.diginamic.model.Director;
import fr.diginamic.persistence.entities.CastEntity;
import fr.diginamic.persistence.entities.DirectorEntity;

/**
 * A DAO (Data Access Object) interface specifically for handling operations related to movie casts.
 */
public interface DirectorDao extends IterableDao<Director, DirectorEntity> {

}
