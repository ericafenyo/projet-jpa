package fr.diginamic.model;

/**
 * Represents a country
 */
public class Country {
    /**
     * The unique identifier for the country.
     */
    private long id;

    /**
     * The name of the country.
     */
    private String name;

    /**
     * The URL of the country.
     */
    private String url;

    /**
     * Returns the unique identifier for the country.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the unique identifier for the country.
     *
     * @param id the identifier to country.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the name for the country.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the country.
     *
     * @param name the country to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the URL for the country.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL of the country.
     *
     * @param url the url to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
