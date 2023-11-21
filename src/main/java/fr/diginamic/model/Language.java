package fr.diginamic.model;

/**
 * Represents a spoken language
 */
public class Language {
    /**
     * The unique identifier for the language.
     */
    private long id;

    /**
     * The name of the language.
     */
    private String name;

    /**
     * Returns the unique identifier for the language.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the unique identifier for the language.
     *
     * @param id the identifier to language.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the name for the language.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the language.
     *
     * @param name the language to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
