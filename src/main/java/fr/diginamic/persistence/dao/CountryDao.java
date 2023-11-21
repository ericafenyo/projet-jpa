package fr.diginamic.persistence.dao;

import fr.diginamic.model.Country;
import fr.diginamic.model.Language;
import fr.diginamic.persistence.entities.CountryEntity;
import fr.diginamic.persistence.entities.LanguageEntity;

/**
 * A DAO (Data Access Object) interface specifically for handling operations related to countries.
 */
public interface CountryDao extends Dao<Country, CountryEntity> { }
