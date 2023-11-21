package fr.diginamic.di;

import fr.diginamic.model.Country;
import fr.diginamic.persistence.dao.CountryDao;
import fr.diginamic.persistence.entities.CountryEntity;
import fr.diginamic.persistence.entities.LanguageEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

class CountryDaoImpl implements CountryDao {
    @Override
    public CountryEntity insert(Country country) {
        // Return quickly when the parameter is null;
        if (country == null) {
            return null;
        }

        EntityManager manager = ServiceLoader.load(EntityManager.class);
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        CountryEntity entity = findOne(country.getName(), manager);

        if (entity == null) {
            entity = new CountryEntity();
            entity.setName(country.getName());
            entity.setUrl(country.getUrl());
            manager.persist(entity);
        }
        transaction.commit();
        return entity;
    }

    private CountryEntity findOne(String name, EntityManager manager) {
        return manager.createQuery("SELECT e FROM CountryEntity e WHERE e.name=:name", CountryEntity.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
