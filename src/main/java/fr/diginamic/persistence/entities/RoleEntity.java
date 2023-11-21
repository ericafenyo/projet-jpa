package fr.diginamic.persistence.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * An entity class that represents a role played by an actor.
 */
@Entity
@Table(name = "roles")
public class RoleEntity {
    /**
     * The unique identifier for the role.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The character's name.
     */
    @Column(name = "name")
    private String name;

    /**
     * The actor playing this role.
     */
    @ManyToOne()
    @JoinColumn(name = "cast_id", referencedColumnName = "id")
    private CastEntity cast;

    /**
     * The movie with which the role is associated.
     */
    @ManyToOne()
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private MovieEntity movie;

    /**
     * Retrieves the unique identifier for the role.
     *
     * @return the unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the role.
     *
     * @param id the identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the character's name for the role.
     *
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the character's name for the role.
     *
     * @param name the character's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the actor playing this role.
     *
     * @return the actor playing the role
     */
    public CastEntity getCast() {
        return cast;
    }

    /**
     * Sets the actor playing this role.
     *
     * @param cast the actor to set
     */
    public void setCast(CastEntity cast) {
        this.cast = cast;
    }

    /**
     * Retrieves the movie in which they are playing this role.
     */
    public MovieEntity getMovie() {
        return movie;
    }

    /**
     * Sets the movie in which the actor plays this role.
     *
     * @param movie the actor to set
     */
    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }
}

