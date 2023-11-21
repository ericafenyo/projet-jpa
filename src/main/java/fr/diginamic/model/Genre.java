package fr.diginamic.model;

/**
 * Represents a genre associated with a movie.
 */
public class Genre {
    /**
     * The unique identifier for the genre.
     */
    private long id;

    /**
     * The name of the genre.
     */
    private String name;


    /**
     * gets the value of the id
     *
     *  @return the current value of the id.
     */
    public long getId() {
        return this.id;
    }

    /**
     * sets the value of the id.
     *
     * @param id the new value to be set.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * gets the value of the name
     *
     *  @return the current value of the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * sets the value of the name.
     *
     * @param name the new value to be set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
