package fr.diginamic.di;

import fr.diginamic.annotation.Provides;
import fr.diginamic.model.Language;
import fr.diginamic.persistence.dao.LanguageDao;
import fr.diginamic.persistence.entities.LanguageEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Provides(type = LanguageDao.class)
class LanguageDaoImpl implements LanguageDao {
    @Override
    public LanguageEntity insert(Language language) {
        // Return quickly when the parameter is null;
        if (language == null) {
            return null;
        }

        EntityManager manager = ServiceLoader.load(EntityManager.class);
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        LanguageEntity entity = findOne(language.getName(), manager);

        if (entity == null) {
            entity = new LanguageEntity();
            entity.setName(language.getName());
            manager.persist(entity);
        }
        transaction.commit();
        return entity;
    }

    private LanguageEntity findOne(String name, EntityManager manager) {
        return manager.createQuery("SELECT e FROM LanguageEntity e WHERE e.name=:name", LanguageEntity.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
