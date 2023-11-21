package fr.diginamic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * A database entity class that represents a genre associated with a movie.
 */
@Entity
@Table(name = "genres")
public class GenreEntity {
    /**
     * The unique identifier for the genre.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the genre.
     */
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genres")
    List<MovieEntity> movies;

    /**
     * Returns the unique identifier for the genre.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier for the genre.
     *
     * @param id the identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name for the genre.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the genre.
     *
     * @param name the genre to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns movies associated with the genre.
     */
    public List<MovieEntity> getMovies() {
        return movies;
    }

    /**
     * Set movies associated with the genre.
     *
     * @param movies movies to set.
     */
    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
}
