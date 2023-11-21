package fr.diginamic.model;

/**
 * Represents an address
 */
public class Location {
    /**
     * The unique identifier for the location.
     */
    private long id;

    /**
     * The name of the location.
     */
    private String name;

    /**
     * Returns the unique identifier for the location.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the unique identifier for the location.
     *
     * @param id the identifier to location.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the name for the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the location.
     *
     * @param name the location to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
