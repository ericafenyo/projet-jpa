package fr.diginamic.persistence.dao;

import fr.diginamic.model.Cast;
import fr.diginamic.model.Genre;
import fr.diginamic.persistence.entities.CastEntity;
import fr.diginamic.persistence.entities.GenreEntity;

/**
 * A DAO (Data Access Object) interface specifically for handling operations related to movie casts.
 */
public interface GenreDao extends IterableDao<Genre, GenreEntity> { }
