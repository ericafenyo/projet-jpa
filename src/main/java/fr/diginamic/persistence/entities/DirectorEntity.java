package fr.diginamic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A database entity class represents a director.
 */
@Entity
@Table(name = "directors")
public class DirectorEntity {
    /**
     * The unique identifier for the director.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The IMDB identifier of the director.
     */
    @Column(name = "imdb_id")
    private String imdbId;

    /**
     * The name of the director.
     */
    @Column(name = "name")
    private String name;

    /**
     * The birthdate of the director.
     */
    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * The birthdate of the director.
     */
    @Column(name = "raw_birth_date", columnDefinition = "JSON")
    private String rawBirthDate;

    /**
     * The birthplace of the director.
     */
    @ManyToOne()
    @JoinColumn(name = "birth_place_id", referencedColumnName = "id")
    private LocationEntity birthPlace;

    /**
     * The URL associated with the director.
     */
    @Column(name = "url")
    private String url;

    /**
     * The height of the director.
     */
    @Column(name = "height")
    private String height;

    /**
     * Collection of movies managed by this director.
     */
    @ManyToMany(mappedBy = "directors")
    private List<MovieEntity> movies = new ArrayList<>();


    /**
     * Get the unique identifier of the director.
     *
     * @return the director's unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the director.
     *
     * @param id The identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the IMDB identifier of the director.
     *
     * @return the IMDB identifier of the director.
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * Set the IMDB identifier of the director.
     *
     * @param imdbId the IMDB identifier to set.
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * Get the name of the director.
     *
     * @return name of the director.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the director.
     *
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the birthplace of the director.
     *
     * @return the birthplace of the director.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set birthDate of the director.
     *
     * @param birthDate the date to set.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the birthplace of the director.
     *
     * @return the birthplace of the director.
     */
    public String getRawBirthDate() {
        return rawBirthDate;
    }

    /**
     * Set birthDate of the director.
     *
     * @param rawBirthDate the date to set.
     */
    public void setRawBirthDate(String rawBirthDate) {
        this.rawBirthDate = rawBirthDate;
    }

    /**
     * Get the birthPlace of the director.
     *
     * @return the birthPlace of the director.
     */
    public LocationEntity getBirthPlace() {
        return birthPlace;
    }

    /**
     * Set birthplace of the director.
     *
     * @param birthPlace the location to set.
     */
    public void setBirthPlace(LocationEntity birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     * Get the URL associated with the director.
     *
     * @return the URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL associated with the director.
     *
     * @param url the associated URL to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the height of the director.
     *
     * @return the height of the director.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Set the height of the director.
     *
     * @param height the height to set.
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Retrieves the movies associated with the director.
     *
     * @return the movies
     */
    public List<MovieEntity> getMovies() {
        return movies;
    }

    /**
     * Sets the movies associated with the director.
     *
     * @param movies movies to set
     */
    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
}
