package fr.diginamic.di;

import fr.diginamic.annotation.Provides;
import fr.diginamic.model.Cast;
import fr.diginamic.persistence.dao.CastDao;
import fr.diginamic.persistence.entities.CastEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Collectors;

@Provides(type = CastDao.class)
class CastDaoImpl implements CastDao {
    @Override
    public void bulkInsert(Iterable<Cast> casts) {
        insert(casts, ServiceLoader.load(EntityManager.class));
    }

    @Override
    public void bulkInsert(Iterable<Cast> casts, EntityManager manager) {
        insert(casts, manager);
    }

    @Override
    public CastEntity insert(Cast type) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);


        return null;
    }

    @Override
    public List<CastEntity> findByProperties(Iterable<String> ids) {
        return find(ids, ServiceLoader.load(EntityManager.class));
    }

    @Override
    public List<CastEntity> findByProperties(Iterable<String> ids, EntityManager manager) {
        return find(ids, manager);
    }

    @Override
    public List<CastEntity> findCastInTwoMovies(String firstMovie, String secondMovie) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);
        String statement = "SELECT c FROM CastEntity as c JOIN c.movies as m1 JOIN c.movies as m2 WHERE m1.name=?1 AND m2.name=?2";
        return manager.createQuery(statement, CastEntity.class)
                .setParameter(1, firstMovie)
                .setParameter(2, secondMovie)
                .getResultList();
    }

    @Override
    public List<CastEntity> findCastByMovie(String name) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);
        String statement = "SELECT c FROM CastEntity as c JOIN c.movies as m WHERE m.name=:name";
        return manager.createQuery(statement, CastEntity.class)
                .setParameter("name", name)
                .getResultList();
    }

    public void insert(Iterable<Cast> casts, EntityManager manager) {
        // Get access to an entity manager
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        for (Cast cast : casts) {
            // Load a cast from the database using the cast's imdb id
            boolean exists = exists(cast.getImdbId(), manager);

            // We will create and save a new cast entity if it does not exist.
            if (!exists) {
                try {
                    CastEntity entity = new CastEntity();
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
        String statement = "SELECT COUNT(c.id)  FROM CastEntity c WHERE c.imdbId=:id";
        Long count = manager.createQuery(statement, Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0L;
    }

    private List<CastEntity> find(Iterable<String> ids, EntityManager manager) {
        return manager.createQuery("SELECT c FROM CastEntity c WHERE c.imdbId IN :ids", CastEntity.class)
                .setParameter("ids", ids)
                .getResultStream()
                .collect(Collectors.toList());
    }

    private List<CastEntity> findOne(Iterable<String> ids, EntityManager manager) {
        return manager.createQuery("SELECT c FROM CastEntity c WHERE c.imdbId IN :ids", CastEntity.class)
                .setParameter("ids", ids)
                .getResultStream()
                .collect(Collectors.toList());
    }
}
