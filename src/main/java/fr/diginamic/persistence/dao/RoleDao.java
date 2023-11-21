package fr.diginamic.persistence.dao;

import fr.diginamic.model.Cast;
import fr.diginamic.model.Role;
import fr.diginamic.persistence.entities.CastEntity;
import fr.diginamic.persistence.entities.RoleEntity;

/**
 * A DAO (Data Access Object) interface specifically for handling operations related to movie casts.
 */
public interface RoleDao extends IterableDao<Role, RoleEntity> { }
