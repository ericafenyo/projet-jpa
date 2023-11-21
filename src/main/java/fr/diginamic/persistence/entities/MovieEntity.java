package fr.diginamic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * A database entity class represents a movie.
 */
@Entity
@Table(name = "movies")
public class MovieEntity {
    /**
     * The unique identifier for the movie.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the movie.
     */
    @Column(name = "name", unique = true, length = 65)
    private String name;

    /**
     * The IMDb ID of the movie.
     */
    @Column(name = "imdb_id", unique = true, length = 20)
    private String imdbId;

    /**
     * The plot summary of the movie.
     */
    @Column(name = "plot", columnDefinition = "TEXT")
    private String plot;

    /**
     * The URL associated with the movie.
     */
    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    /**
     * The release year of the movie.
     */
    @Column(name = "year")
    private Integer year;

    /**
     * The rating of the movie.
     */
    @Column(name = "rating")
    private Double rating;

    /**
     * The language of the movie.
     */
    @ManyToOne()
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private LanguageEntity language;

    /**
     * The language of the movie.
     */
    @ManyToOne()
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;

    @ManyToOne()
    @JoinColumn(name = "shooting_location_id", referencedColumnName = "id")
    private LocationEntity shootingLocation;

    /**
     * The roles in the movie.
     */
    @OneToMany(mappedBy = "movie")
    private List<RoleEntity> roles;

    /**
     * The actors or an actresses playing a role in a film.
     */
    @ManyToMany()
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_id")
    )
    private List<CastEntity> casts = new ArrayList<>();

    /**
     * The directors of the movie
     */
    @ManyToMany()
    @JoinTable(
            name = "movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<DirectorEntity> directors = new ArrayList<>();


    /**
     * The genres associated with a movie.
     */
    @ManyToMany()
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> genres;


    /**
     * gets the value of the id
     *
     *  @return the current value of the id.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * sets the value of the id.
     *
     * @param id the new value to be set.
     */
    public void setId(Long id) {
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
     * gets the value of the language
     *
     *  @return the current value of the language.
     */
    public LanguageEntity getLanguage() {
        return this.language;
    }

    /**
     * sets the value of the language.
     *
     * @param language the new value to be set.
     */
    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    /**
     * gets the value of the country
     *
     *  @return the current value of the country.
     */
    public CountryEntity getCountry() {
        return this.country;
    }

    /**
     * sets the value of the country.
     *
     * @param country the new value to be set.
     */
    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    /**
     * gets the value of the shootingLocation
     *
     *  @return the current value of the shootingLocation.
     */
    public LocationEntity getShootingLocation() {
        return this.shootingLocation;
    }

    /**
     * sets the value of the shootingLocation.
     *
     * @param shootingLocation the new value to be set.
     */
    public void setShootingLocation(LocationEntity shootingLocation) {
        this.shootingLocation = shootingLocation;
    }

    /**
     * gets the value of the roles
     *
     *  @return the current value of the roles.
     */
    public List<RoleEntity> getRoles() {
        return this.roles;
    }

    /**
     * sets the value of the roles.
     *
     * @param roles the new value to be set.
     */
    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    /**
     * gets the value of the casts
     *
     *  @return the current value of the casts.
     */
    public List<CastEntity> getCasts() {
        return this.casts;
    }

    /**
     * sets the value of the casts.
     *
     * @param casts the new value to be set.
     */
    public void setCasts(List<CastEntity> casts) {
        this.casts = casts;
    }

    /**
     * gets the value of the directors
     *
     *  @return the current value of the directors.
     */
    public List<DirectorEntity> getDirectors() {
        return this.directors;
    }

    /**
     * sets the value of the directors.
     *
     * @param directors the new value to be set.
     */
    public void setDirectors(List<DirectorEntity> directors) {
        this.directors = directors;
    }

    /**
     * gets the value of the genres
     *
     *  @return the current value of the genres.
     */
    public List<GenreEntity> getGenres() {
        return this.genres;
    }

    /**
     * sets the value of the genres.
     *
     * @param genres the new value to be set.
     */
    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }
}
