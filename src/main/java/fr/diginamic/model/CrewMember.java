package fr.diginamic.model;

import java.time.LocalDate;
import java.util.Map;

/**
 * Represents a crew member involved in a production.
 */
public class CrewMember {

    /**
     * The unique identifier of the crew member.
     */
    protected long id;

    /**
     * The IMDB identifier of the crew member.
     */
    protected String imdbId;

    /**
     * The name of the crew member.
     */
    protected String name;

    /**
     * The birthdate of the crew member.
     */
    protected LocalDate birthDate;

    /**
     * Raw birthdate information in a map format.
     */
    protected Map<String, String> rawBirthDate;

    /**
     * The birthplace of the crew member.
     */
    protected Location birthPlace;

    /**
     * The URL associated with the crew member.
     */
    protected String url;

    /**
     * The height of the crew member.
     */
    protected String height;

    /**
     * Get the unique identifier of the crew member.
     *
     * @return the crew member's unique identifier.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the crew member.
     *
     * @param id The identifier to set.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the IMDB identifier of the crew member.
     *
     * @return the IMDB identifier of the crew member..
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * Set the IMDB identifier of the crew member.
     *
     * @param imdbId the IMDB identifier to set.
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * Get the name of the crew member.
     *
     * @return name of the crew member.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the crew member.
     *
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the birthplace of the crew member.
     *
     * @return the birthplace of the crew member.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set birthDate of the crew member.
     *
     * @param birthDate the date to set.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the birthplace of the crew member.
     *
     * @return the birthplace of the crew member.
     */
    public Map<String, String> getRawBirthDate() {
        return rawBirthDate;
    }

    /**
     * Set birthDate of the crew member.
     *
     * @param rawBirthDate the date to set.
     */
    public void setRawBirthDate(Map<String, String> rawBirthDate) {
        this.rawBirthDate = rawBirthDate;
    }

    /**
     * Get the birthPlace of the crew member.
     *
     * @return the birthPlace of the crew member.
     */
    public Location getBirthPlace() {
        return birthPlace;
    }

    /**
     * Set birthplace of the crew member.
     *
     * @param birthPlace the location to set.
     */
    public void setBirthPlace(Location birthPlace) {
        this.birthPlace = birthPlace;
    }


    /**
     * Get the URL associated with the crew member.
     *
     * @return the URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL associated with the crew member.
     *
     * @param url the associated URL to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the height of the crew member.
     *
     * @return the height of the crew member.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Set the height of the crew member.
     *
     * @param height the height to set.
     */
    public void setHeight(String height) {
        this.height = height;
    }
}
