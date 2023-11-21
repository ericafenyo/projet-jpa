package fr.diginamic.model;

/**
 * The director of a movie.
 */
public class Director extends CrewMember {

    public static Director buildFrom(CrewMember member) {
        Director director = new Director();
        director.setName(member.name);
        director.setImdbId(member.imdbId);
        director.setUrl(member.url);
        director.setHeight(member.height);
        director.setBirthDate(member.birthDate);
        director.setBirthPlace(member.birthPlace);
        return director;
    }
}
