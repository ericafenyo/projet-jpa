package fr.diginamic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * A database entity class that represents a location an address.
 */
@Entity
@Table(name = "locations")
public class LocationEntity {
    /**
     * The unique identifier for the location.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the location.
     */
    @Column(name = "name")
    private String name;

    /**
     * Collections of movies shot at this location.
     */
    @OneToMany(mappedBy = "shootingLocation")
    private List<MovieEntity> movies = new ArrayList<>();

    /**
     * Collections of casts born at this location.
     */
    @OneToMany(mappedBy = "birthPlace")
    private List<CastEntity> casts = new ArrayList<>();

    /**
     * Collections of directors born at this location.
     */
    @OneToMany(mappedBy = "birthPlace")
    private List<DirectorEntity> directors = new ArrayList<>();

    /**
     * gets the value of the id
     *
     * @return the current value of the id.
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
     * @return the current value of the name.
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
     * gets the value of the movies
     *
     * @return the current value of the movies.
     */
    public List<MovieEntity> getMovies() {
        return this.movies;
    }

    /**
     * sets the value of the movies.
     *
     * @param movies the new value to be set.
     */
    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

    /**
     * gets the value of the casts
     *
     * @return the current value of the casts.
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
     * @return the current value of the directors.
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
}
