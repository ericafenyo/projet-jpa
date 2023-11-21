package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    /**
     * The unique identifier for the movie.
     */
    private long id;

    /**
     * The name of the movie.
     */
    private String name;

    /**
     * The IMDb ID of the movie.
     */
    private String imdbId;

    /**
     * The plot summary of the movie.
     */
    private String plot;

    /**
     * The URL associated with the movie.
     */
    private String url;

    /**
     * The language of the movie.
     */
    private Language language;

    /**
     * The release year of the movie.
     */

    private Country country;

    /**
     * The release year of the movie.
     */

    private Location location;

    /**
     * The rating of the movie.
     */
    private Integer year;

    /**
     * The rating of the movie.
     */
    private Double rating;

    /**
     * The roles in the movie.
     */
    private List<Role> roles;

    /**
     * The actors or an actresses playing a role in a film.
     */
    private List<Cast> casts;

    /**
     * The directors of the movie
     */
    private List<Director> directors;

    /**
     * The genres associated with a movie.
     */
    private List<Genre> genres = new ArrayList<>();


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

    /**
     * gets the value of the imdbId
     *
     *  @return the current value of the imdbId.
     */
    public String getImdbId() {
        return this.imdbId;
    }

    /**
     * sets the value of the imdbId.
     *
     * @param imdbId the new value to be set.
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * gets the value of the plot
     *
     *  @return the current value of the plot.
     */
    public String getPlot() {
        return this.plot;
    }

    /**
     * sets the value of the plot.
     *
     * @param plot the new value to be set.
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * gets the value of the url
     *
     *  @return the current value of the url.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * sets the value of the url.
     *
     * @param url the new value to be set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * gets the value of the language
     *
     *  @return the current value of the language.
     */
    public Language getLanguage() {
        return this.language;
    }

    /**
     * sets the value of the language.
     *
     * @param language the new value to be set.
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * gets the value of the country
     *
     *  @return the current value of the country.
     */
    public Country getCountry() {
        return this.country;
    }

    /**
     * sets the value of the country.
     *
     * @param country the new value to be set.
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * gets the value of the location
     *
     *  @return the current value of the location.
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * sets the value of the location.
     *
     * @param location the new value to be set.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * gets the value of the year
     *
     *  @return the current value of the year.
     */
    public Integer getYear() {
        return this.year;
    }

    /**
     * sets the value of the year.
     *
     * @param year the new value to be set.
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * gets the value of the rating
     *
     *  @return the current value of the rating.
     */
    public Double getRating() {
        return this.rating;
    }

    /**
     * sets the value of the rating.
     *
     * @param rating the new value to be set.
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * gets the value of the roles
     *
     *  @return the current value of the roles.
     */
    public List<Role> getRoles() {
        return this.roles;
    }

    /**
     * sets the value of the roles.
     *
     * @param roles the new value to be set.
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * gets the value of the casts
     *
     *  @return the current value of the casts.
     */
    public List<Cast> getCasts() {
        return this.casts;
    }

    /**
     * sets the value of the casts.
     *
     * @param casts the new value to be set.
     */
    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    /**
     * gets the value of the directors
     *
     *  @return the current value of the directors.
     */
    public List<Director> getDirectors() {
        return this.directors;
    }

    /**
     * sets the value of the directors.
     *
     * @param directors the new value to be set.
     */
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    /**
     * gets the value of the genres
     *
     *  @return the current value of the genres.
     */
    public List<Genre> getGenres() {
        return this.genres;
    }

    /**
     * sets the value of the genres.
     *
     * @param genres the new value to be set.
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
