package fr.diginamic.di;

import fr.diginamic.annotation.Provides;
import fr.diginamic.model.Director;
import fr.diginamic.persistence.dao.DirectorDao;
import fr.diginamic.persistence.entities.DirectorEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Collectors;

@Provides(type = DirectorDao.class)
class DirectorDaoImpl implements DirectorDao {

    @Override
    public void bulkInsert(Iterable<Director> directors) {
        save(directors, ServiceLoader.load(EntityManager.class));
    }

    @Override
    public void bulkInsert(Iterable<Director> directors, EntityManager manager) {
        save(directors, manager);
    }

    @Override
    public DirectorEntity insert(Director director) {
        return null;
    }

    @Override
    public List<DirectorEntity> findByProperties(Iterable<String> properties) {
        return null;
    }

    @Override
    public List<DirectorEntity> findByProperties(Iterable<String> properties, EntityManager manager) {
        return null;
    }

    public void save(Iterable<Director> directors, EntityManager manager) {
        // Get access to an entity manager
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        for (Director cast : directors) {
            // Load a cast from the database using the cast's imdb id
            boolean exists = exists(cast.getImdbId(), manager);

            // We will create and save a new cast entity if it does not exist.
            if (!exists) {
                try {
                    DirectorEntity entity = new DirectorEntity();
                    entity.setName(cast.getName());
                    entity.setHeight(cast.getHeight());
                    entity.setUrl(cast.getUrl());
                    entity.setImdbId(cast.getImdbId());
                    manager.persist(entity);

                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
        transaction.commit();
    }

    private boolean exists(String id, EntityManager manager) {
        String statement = "SELECT COUNT(e.id)  FROM DirectorEntity e WHERE e.imdbId=:id";
        Long count = manager.createQuery(statement, Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0L;
    }

    private List<DirectorEntity> find(Iterable<String> ids, EntityManager manager) {
        return manager.createQuery("SELECT e FROM DirectorEntity e WHERE e.imdbId IN :ids", DirectorEntity.class)
                .setParameter("ids", ids)
                .getResultStream()
                .collect(Collectors.toList());
    }

    private DirectorEntity findOne(Iterable<String> ids, EntityManager manager) {
        return manager.createQuery("SELECT e FROM DirectorEntity e WHERE e.imdbId IN :ids", DirectorEntity.class)
                .setParameter("ids", ids)
                .getSingleResult();
    }
}
