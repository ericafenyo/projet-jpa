package fr.diginamic.model;

/**
 * Represents a role played by an actor.
 */
public class Role {
    /**
     * The unique identifier for the role.
     */
    private long id;

    /**
     * The character's name.
     */
    private String character;

    /**
     * The actor playing this role.
     */
    private Cast actor;

    /**
     * Retrieves the unique identifier for the role.
     *
     * @return the unique identifier.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the role.
     *
     * @param id the identifier to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieves the character's name for the role.
     *
     * @return the character's name
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Sets the character's name for the role.
     *
     * @param character the character's name to set
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * Retrieves the actor playing this role.
     *
     * @return the actor playing the role
     */
    public Cast getActor() {
        return actor;
    }

    /**
     * Sets the actor playing this role.
     *
     * @param actor the actor to set
     */
    public void setActor(Cast actor) {
        this.actor = actor;
    }
}

