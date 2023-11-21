package fr.diginamic.di;

import fr.diginamic.annotation.Provides;
import fr.diginamic.model.Location;
import fr.diginamic.persistence.dao.LanguageDao;
import fr.diginamic.persistence.dao.LocationDao;
import fr.diginamic.persistence.entities.LocationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Provides(type = LanguageDao.class)
class LocationDaoImpl implements LocationDao {
    @Override
    public LocationEntity insert(Location location) {
        // Return quickly when the parameter is null;
        if (location == null) {
            return null;
        }

        EntityManager manager = ServiceLoader.load(EntityManager.class);
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        LocationEntity entity = findOne(location.getName(), manager);

        if (entity == null) {
            entity = new LocationEntity();
            entity.setName(location.getName());
            manager.persist(entity);
        }
        transaction.commit();
        return entity;
    }

    private LocationEntity findOne(String name, EntityManager manager) {
        return manager.createQuery("SELECT e FROM LocationEntity e WHERE e.name=:name", LocationEntity.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
