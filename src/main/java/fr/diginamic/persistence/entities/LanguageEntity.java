package fr.diginamic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * A database entity class that represents the languages a movie is associated with.
 */
@Entity
@Table(name = "languages")
public class LanguageEntity {
    /**
     * The unique identifier for the language.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the language.
     */
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "language")

    private List<MovieEntity> movies = new ArrayList<>();

    /**
     * Returns the unique identifier for the language.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier for the language.
     *
     * @param id the identifier to language.
     */
    public void setId(Long id) {
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

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
}
