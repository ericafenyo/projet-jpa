package fr.diginamic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A database entity class represents a movie.
 */
@Entity
@Table(name = "casts")
public class CastEntity {
    /**
     * The unique identifier for the cast.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The IMDB identifier of the cast.
     */
    @Column(name = "imdb_id")
    private String imdbId;

    /**
     * The name of the cast.
     */
    @Column(name = "name")
    private String name;

    /**
     * The birthdate of the cast.
     */
    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * The birthdate of the cast.
     */
    @Column(name = "raw_birth_date", columnDefinition = "JSON")
    private String rawBirthDate;

    /**
     * The birthplace of the cast.
     */
    @ManyToOne()
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity birthPlace;

    /**
     * The URL associated with the cast.
     */
    @Column(name = "url")
    private String url;

    /**
     * The height of the cast.
     */
    @Column(name = "height")
    private String height;

    @OneToMany(mappedBy = "cast")
    private List<RoleEntity> roles;

    @ManyToMany(mappedBy = "casts")
    private List<MovieEntity> movies = new ArrayList<>();

    /**
     * Get the unique identifier of the cast.
     *
     * @return the cast's unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the cast.
     *
     * @param id The identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the IMDB identifier of the cast.
     *
     * @return the IMDB identifier of the cast..
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * Set the IMDB identifier of the cast.
     *
     * @param imdbId the IMDB identifier to set.
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * Get the name of the cast.
     *
     * @return name of the cast.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the cast.
     *
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the birthplace of the cast.
     *
     * @return the birthplace of the cast.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set birthDate of the cast.
     *
     * @param birthDate the date to set.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the birthplace of the cast.
     *
     * @return the birthplace of the cast.
     */
    public String getRawBirthDate() {
        return rawBirthDate;
    }

    /**
     * Set birthDate of the cast.
     *
     * @param rawBirthDate the date to set.
     */
    public void setRawBirthDate(String rawBirthDate) {
        this.rawBirthDate = rawBirthDate;
    }

    /**
     * Get the birthPlace of the cast.
     *
     * @return the birthPlace of the cast.
     */
    public LocationEntity getBirthPlace() {
        return birthPlace;
    }

    /**
     * Set birthplace of the cast.
     *
     * @param birthPlace the location to set.
     */
    public void setBirthPlace(LocationEntity birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     * Get the URL associated with the cast.
     *
     * @return the URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL associated with the cast.
     *
     * @param url the associated URL to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the height of the cast.
     *
     * @return the height of the cast.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Set the height of the cast.
     *
     * @param height the height to set.
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Retrieves the roles in the movie.
     *
     * @return the roles in the movie
     */
    public List<RoleEntity> getRoles() {
        return roles;
    }

    /**
     * Sets the roles in the movie.
     *
     * @param roles the roles to set
     */
    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    /**
     * Retrieves the movies associated with the cast.
     *
     * @return the movies
     */
    public List<MovieEntity> getMovies() {
        return movies;
    }

    /**
     * Sets the movies associated with the cast.
     *
     * @param movies movies to set
     */
    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
}
