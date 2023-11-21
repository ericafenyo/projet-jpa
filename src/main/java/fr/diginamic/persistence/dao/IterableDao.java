package fr.diginamic.persistence.dao;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;


/**
 * A generic interface for performing operations on an iterable for a specific entity type.
 *
 * @param <T> The object containing the data to be inserted.
 * @param <E> The entity to retrieve.
 */
public interface IterableDao<T, E> {

    /**
     * Inserts entities into the database.
     *
     * @param types the entities to be inserted.
     */
    void bulkInsert(Iterable<T> types);

    /**
     * Inserts entities into the database using the provided EntityManager.
     *
     * @param types   the entities to be inserted.
     * @param manager EntityManager to use for insertion.
     */
    void bulkInsert(Iterable<T> types, EntityManager manager);

    /**
     * Inserts a new entity of type T into the data store and returns the inserted entity.
     *
     * @param type The entity to be inserted.
     * @return The inserted entity of type E.
     */
    E insert(T type);

    /**
     * Retrieves entities based on the given properties.
     *
     * @param properties the properties to search for.
     * @return the entities that match the provided properties.
     */
    List<E> findByProperties(Iterable<String> properties);

    /**
     * Retrieves entities based on the given properties.
     *
     * @param properties the properties to search for.
     * @param manager    EntityManager to use for retrieval.
     * @return the entities that match the provided properties.
     */
    List<E> findByProperties(Iterable<String> properties, EntityManager manager);
}
