package fr.diginamic.model;

/**
 * An actor or an actress playing a role in a film.
 */
public class Cast extends CrewMember {

    @Override
    public String toString() {
        return "Cast{" +
                "id=" + id +
                ", imdbId='" + imdbId + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace=" + birthPlace +
                ", rawBirthDate=" + rawBirthDate +
                ", url='" + url + '\'' +
                ", height='" + height + '\'' +
                '}';
    }

    public static Cast buildFrom(CrewMember member) {
        Cast cast = new Cast();
        cast.setId(member.id);
        cast.setImdbId(member.imdbId);
        cast.setName(member.name);
        cast.setBirthDate(member.birthDate);
        cast.setBirthPlace(member.birthPlace);
        cast.setRawBirthDate(member.rawBirthDate);
        cast.setUrl(member.url);
        cast.setHeight(member.height);
        return cast;
    }
}
