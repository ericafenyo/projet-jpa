package fr.diginamic.di;

import fr.diginamic.annotation.Provides;
import fr.diginamic.model.Cast;
import fr.diginamic.model.Role;
import fr.diginamic.persistence.dao.CastDao;
import fr.diginamic.persistence.dao.RoleDao;
import fr.diginamic.persistence.entities.CastEntity;
import fr.diginamic.persistence.entities.RoleEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Provides(type = RoleDao.class)
class RoleDaoImpl implements RoleDao {
    @Override
    public void bulkInsert(Iterable<Role> roles) {
        insert(roles, ServiceLoader.load(EntityManager.class));
    }

    @Override
    public void bulkInsert(Iterable<Role> roles, EntityManager manager) {
        insert(roles, manager);
    }

    @Override
    public RoleEntity insert(Role role) {
        EntityManager manager = ServiceLoader.load(EntityManager.class);

        RoleEntity entity = findOne(role, manager);
        return entity;
    }

    @Override
    public List<RoleEntity> findByProperties(Iterable<String> properties) {
        return null;
    }

    @Override
    public List<RoleEntity> findByProperties(Iterable<String> properties, EntityManager manager) {
        return null;
    }

    public void insert(Iterable<Role> roles, EntityManager manager) {
        // Get access to an entity manager
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        for (Role role : roles) {
            // Load a cast from the database using the cast's imdb id
            boolean exists = exists(role, manager);

            // We will create and save a new cast entity if it does not exist.
            if (!exists) {
                try {
//                    CastEntity cast = castDao.insert(role.getActor());
                    RoleEntity entity = new RoleEntity();
                    entity.setName(role.getCharacter());
                    manager.persist(entity);

                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
        transaction.commit();
    }

    private boolean exists(Role role, EntityManager manager) {
        String statement = "SELECT COUNT(r)  FROM RoleEntity r JOIN r.cast c WHERE r.name=:name AND c.imdbId=:imdbId";
        Long count = manager.createQuery(statement, Long.class)
                .setParameter("name", role.getCharacter())
                .setParameter("imdbId", role.getActor().getImdbId())
                .getSingleResult();
        return count > 0L;
    }

    private RoleEntity findOne(Role role, EntityManager manager) {
        String statement = "SELECT r FROM RoleEntity r JOIN r.cast c WHERE r.name=:name AND c.imdbId=:id";
        return manager.createQuery(statement, RoleEntity.class)
                .setParameter("name", role.getCharacter())
                .setParameter("id", role.getActor().getImdbId())
                .setMaxResults(1)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

//    private List<RoleEntity> find(Iterable<Role> roles, EntityManager manager) {
//        List<String> imdbIds = new ArrayList<>();
//        List<String> names = new ArrayList<>();
//
//        roles.forEach(role -> {
//            imdbIds.add(role.getActor().getImdbId());
//            names.add(role.getCharacter());
//        });
//
//
//        String statement = "SELECT r  FROM RoleEntity r JOIN r.cast c WHERE r.name IN :name AND c.imdbId=:imdbId";
//        return manager.createQuery(statement, RoleEntity.class)
//                .setParameter("name", role.getCharacter())
//                .setParameter("imdbId", role.getActor().getImdbId())
//                .getResultStream()
//                .collect(Collectors.toList());
//    }
}
