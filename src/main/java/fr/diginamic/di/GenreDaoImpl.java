package fr.diginamic.di;

import fr.diginamic.annotation.Provides;
import fr.diginamic.model.Genre;
import fr.diginamic.persistence.dao.GenreDao;
import fr.diginamic.persistence.entities.GenreEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Collectors;

@Provides(type = GenreDao.class)
public class GenreDaoImpl implements GenreDao {

    @Override
    public void bulkInsert(Iterable<Genre> genres) {
        save(genres, ServiceLoader.load(EntityManager.class));
    }

    @Override
    public void bulkInsert(Iterable<Genre> genres, EntityManager manager) {
        save(genres, manager);
    }

    @Override
    public GenreEntity insert(Genre type) {
        return null;
    }

    @Override
    public List<GenreEntity> findByProperties(Iterable<String> properties) {
        return find(properties, ServiceLoader.load(EntityManager.class));
    }

    @Override
    public List<GenreEntity> findByProperties(Iterable<String> properties, EntityManager manager) {
        return find(properties, manager);
    }

    private boolean exists(String name, EntityManager manager) {
        String statement = "SELECT COUNT(e.id)  FROM GenreEntity e WHERE e.name=:name";
        Long count = manager.createQuery(statement, Long.class)
                .setParameter("name", name)
                .getSingleResult();
        return count > 0L;
    }

    private void save(Iterable<Genre> genres, EntityManager manager) {
        // Get access to an entity manager
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        for (Genre cast : genres) {
            // Verify if the entity already exists in the database
            boolean exists = exists(cast.getName(), manager);

            // We will create and save a new entity if it does not exist.
            if (!exists) {
                try {
                    GenreEntity entity = new GenreEntity();
                    entity.setName(cast.getName());
                    manager.persist(entity);

                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        }

        transaction.commit();
    }

    private List<GenreEntity> find(Iterable<String> names, EntityManager manager) {
        return manager.createQuery("SELECT e FROM GenreEntity e WHERE e.name IN :names", GenreEntity.class)
                .setParameter("names", names)
                .getResultStream()
                .collect(Collectors.toList());
    }
}
