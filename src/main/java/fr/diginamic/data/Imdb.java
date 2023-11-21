package fr.diginamic.data;

import fr.diginamic.model.Country;
import fr.diginamic.model.Genre;
import fr.diginamic.model.Language;
import fr.diginamic.model.Location;
import fr.diginamic.model.Cast;
import fr.diginamic.model.CrewMember;
import fr.diginamic.model.Director;
import fr.diginamic.model.Movie;
import fr.diginamic.model.Role;
import fr.diginamic.util.Pair;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Imdb {
    /**
     * Collection of parsed movie objects.
     */
    private final List<Movie> movies;

    /**
     * Collection of json string that could not be parsed.
     */
    private final List<String> errors;

    /**
     * The movies Json file location
     */
    private static final String FILE_URI = "assets/films.json";

    /**
     * This constructor can only be used within this class
     *
     * @see #create()
     */
    private Imdb(List<Movie> movies, List<String> errors) {
        this.movies = movies;
        this.errors = errors;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    /**
     * Creates a singleton of OpenFoodFact.
     *
     * @return An OpenFoodFact instance.
     */
    public static Imdb create() throws IOException {
        Set<Movie> movies = new HashSet<>();
        List<String> errors = new ArrayList<>();

        JSONArray objects = readJsonFile();

        for (int index = 0; index < objects.length(); index++) {
            JSONObject object = objects.getJSONObject(index);

            Movie movie = buildMovie(object);
            if (movie != null) {
                movies.add(movie);
            } else {
                errors.add(object.toString());
            }
        }

        return new Imdb(movies.stream().toList(), errors);
    }

    /**
     * Builds a Movie object from a JSONObject.
     *
     * @param object The JSONObject containing data for the movie.
     * @return A {@link Movie} object.
     */
    private static Movie buildMovie(JSONObject object) {
        Movie movie = new Movie();

        // Set name
        String name = object.optString(Constants.KEY_NAME);
        movie.setName(name);

        // Set name IMDb id
        String imdbId = object.optString(Constants.KEY_ID);
        movie.setImdbId(imdbId);

        // Set plot summary
        String plot = object.optString(Constants.KEY_PLOT);
        movie.setPlot(plot);

        // Set url
        String url = object.optString(Constants.KEY_URL);
        movie.setUrl(plot);

        // Set Year
        Integer parsedYear = parseYear(object.optString(Constants.KEY_RELEASE_YEAR));
        if (parsedYear != null) {
            movie.setYear(parsedYear);
        }

        String rating = object.optString(Constants.KEY_RATING);
        if (!rating.isBlank()) {
            movie.setRating(Double.valueOf(rating));
        }

        // Set language
        Language language = buildLanguage(object.optString(Constants.KEY_LANGUAGE));
        if (language != null) {
            movie.setLanguage(language);
        }

        // Set language
        Country country = buildCountry(object.optJSONObject(Constants.KEY_COUNTRY));
        if (country != null) {
            movie.setCountry(country);
        }

        // Set shooting location,
        Location shootingLocation = buildShootingLocation(object.optJSONObject(Constants.KEY_SHOOTING_LOCATION));
        if (shootingLocation != null) {
            movie.setLocation(shootingLocation);
        }

        // set genres
        List<Genre> genres = buildGenres(object.optJSONArray(Constants.KEY_GENRES));
        movie.setGenres(genres);

        List<Role> roles = buildRoles(object.optJSONArray(Constants.KEY_ROLES));
        movie.setRoles(roles);

        List<Cast> casts = buildCasts(object.optJSONArray(Constants.KEY_CASTS));
        movie.setCasts(casts);

        List<Director> directors = buildDirectors(object.optJSONArray(Constants.KEY_DIRECTORS));
        movie.setDirectors(directors);

        return movie;
    }

    private static Integer parseYear(String value) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
            TemporalAccessor accessor = formatter.parse(value);
            return accessor.get(ChronoField.YEAR);
        } catch (Exception exception) {
            return null;
        }
    }

    private static List<Genre> buildGenres(JSONArray array) {
        if (array == null || array.isEmpty()) {
            return Collections.emptyList();
        }

        List<Genre> genres = new ArrayList<>();

        for (int index = 0; index < array.length(); index++) {
            String value = array.optString(index);

            if (!value.isBlank()) {
                Genre genre = new Genre();
                genre.setName(value);
                genres.add(genre);
            }
        }
        return genres;
    }

    private static Location buildShootingLocation(JSONObject object) {
        if (object == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();

        String city = object.optString(Constants.KEY_CITY);
        String department = object.optString(Constants.KEY_STATE_DEPARTMENT);
        String country = object.optString(Constants.KEY_COUNTRY);

        if (!city.isBlank()) {
            builder.append(city.trim()).append(", ");
        }

        if (!department.isBlank()) {
            builder.append(department.trim()).append(", ");
        }

        if (!country.isBlank()) {
            builder.append(country.trim());
        }

        String value = builder.toString();
        if (value.isBlank()) {
            return null;
        }

        Location location = new Location();
        location.setName(value);
        return location;
    }

    private static Country buildCountry(JSONObject object) {
        if (object == null) {
            return null;
        }

        String name = object.optString(Constants.KEY_NAME);
        String url = object.optString(Constants.KEY_URL);

        Country country = new Country();
        country.setName(name);
        country.setUrl(url);
        return country;
    }

    private static Language buildLanguage(String value) {
        if (value.isBlank()) {
            return null;
        }

        Language language = new Language();
        language.setName(value);
        return language;
    }

    private static List<Cast> buildCasts(JSONArray array) {
        Set<Cast> casts = new HashSet<>();
        for (int index = 0; index < array.length(); index++) {
            JSONObject object = array.getJSONObject(index);
            CrewMember crewMember = buildCrewMember(object);
            Cast cast = Cast.buildFrom(crewMember);
            casts.add(cast);
        }

        return casts.stream().toList();
    }

    private static List<Director> buildDirectors(JSONArray array) {
        Set<Director> directors = new HashSet<>();
        for (int index = 0; index < array.length(); index++) {
            JSONObject object = array.getJSONObject(index);
            CrewMember crewMember = buildCrewMember(object);
            Director director = Director.buildFrom(crewMember);
            directors.add(director);
        }

        return directors.stream().toList();
    }

    /**
     * Builds a list of role objects from a JSONArray.
     *
     * @param array The JSONArray containing data for the roles.
     * @return A list of {@link Role} objects.
     */
    private static List<Role> buildRoles(JSONArray array) {
        Set<Role> roles = new HashSet<>();
        for (int index = 0; index < array.length(); index++) {
            JSONObject object = array.getJSONObject(index);

            // Get the character name
            String character = object.optString(Constants.KEY_CHARACTER_NAME);

            // Get the cast playing this role
            CrewMember member = buildCrewMember(object.optJSONObject(Constants.KEY_ACTOR));
            Cast actor = Cast.buildFrom(member);
            // Construct a role object
            Role role = new Role();
            role.setCharacter(character);
            role.setActor(actor);
            roles.add(role);
        }

        return roles.stream().toList();
    }


    /**
     * Builds a Cast object from a JSONObject.
     *
     * @param object The JSONObject containing data for the cast.
     * @return A {@link Cast} object.
     */
    private static CrewMember buildCrewMember(JSONObject object) {
        // Return fast if the parameter is null
        if (object == null) {
            return null;
        }

        // Get all values from the json object
        String name = object.optString(Constants.KEY_IDENTITY);
        String id = object.optString(Constants.KEY_ID);
        String url = object.optString(Constants.KEY_URL);
        String height = object.optString(Constants.KEY_HEIGHT);

        Pair<LocalDate, Map<String, String>> pair = buildDate(object.optJSONObject(Constants.KEY_BIRTH));

        Location birthPlace = buildLocation(object.optJSONObject(Constants.KEY_BIRTH));
        // Build and return a cast object
        CrewMember member = new CrewMember();
        member.setName(name);
        member.setImdbId(id);
        member.setUrl(url);
        member.setBirthDate(pair.getFirst());
        member.setBirthPlace(birthPlace);
        member.setRawBirthDate(pair.getSecond());
        member.setHeight(height);

        return member;
    }

    private static Pair<LocalDate, Map<String, String>> buildDate(JSONObject object) {
        String dateString = object.optString(Constants.KEY_BIRTH_DATE).trim();
        // This will contain our raw date.
        Map<String, String> map = new HashMap<>();

        // Return fast when the parameter is an empty string
        if (dateString.isBlank()) {
            return new Pair<>(null, map);
        }

        // We will parse all cases available in the data
        String[] parts = dateString.split(" ");
        if (parts.length == 1) {
            try {
                // When we have 1 part, then it is "Year". Example 3022.
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
                TemporalAccessor accessor = formatter.parse(dateString);
                map.put("year ", String.valueOf(accessor.get(ChronoField.YEAR)));
                return new Pair<>(null, map);
            } catch (DateTimeException exception) {
                return new Pair<>(null, map);
            }
        } else if (parts.length == 2) {
            try {
                // When we have 2 part, then it is "Month" and "Day". Example May 6.
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");
                TemporalAccessor accessor = formatter.parse(dateString);

                map.put("month ", String.valueOf(accessor.get(ChronoField.MONTH_OF_YEAR)));
                map.put("day ", String.valueOf(accessor.get(ChronoField.DAY_OF_MONTH)));
                return new Pair<>(null, map);
            } catch (DateTimeException exception) {
                return new Pair<>(null, map);
            }
        } else if (parts.length == 3) {
            try {
                // When we have 3 part, then it is "Month", "Day" and "Year. Example May 6 3022.
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
                TemporalAccessor accessor = formatter.parse(dateString);

                map.put("month ", String.valueOf(accessor.get(ChronoField.MONTH_OF_YEAR)));
                map.put("day ", String.valueOf(accessor.get(ChronoField.DAY_OF_MONTH)));
                map.put("year ", String.valueOf(accessor.get(ChronoField.YEAR)));

                LocalDate localDate = LocalDate.parse(dateString, formatter);
                return new Pair<>(localDate, map);
            } catch (DateTimeException exception) {
                return new Pair<>(null, map);
            }
        } else {
            return new Pair<>(null, map);
        }
    }

    private static Location buildLocation(JSONObject object) {
        String value = object.optString(Constants.KEY_BIRTH_PLACE);
        Location location = new Location();

        // Return fast when the value is blank
        if (value.isBlank()) {
            return location;
        }

        location.setName(value.trim());
        return location;
    }

    /**
     * Reads a JSON file and returns its content as a JSONArray.
     *
     * @return A JSONArray containing the data from the JSON file.
     * @throws IOException If there's an error reading the file.
     */
    private static JSONArray readJsonFile() throws IOException {
        Path path = Path.get(FILE_URI);
        Source source = FileSystem.SYSTEM.source(path);
        BufferedSource bufferedSource = Okio.buffer(source);
        String data = bufferedSource.readUtf8();
        bufferedSource.close();

        return new JSONArray(data);
    }

    private static class Constants {
        public static final String KEY_SHOOTING_LOCATION = "lieuTournage";
        public static final String KEY_CASTS = "castingPrincipal";
        public static final String KEY_DIRECTORS = "realisateurs";
        public static final String KEY_RELEASE_YEAR = "anneeSortie";
        public static final String KEY_RATING = "rating";
        public static final String KEY_LANGUAGE = "langue";
        public static final String KEY_NAME = "nom";
        public static final String KEY_URL = "url";
        public static final String KEY_PLOT = "plot";
        public static final String KEY_GENRES = "genres";
        public static final String KEY_ID = "id";
        public static final String KEY_COUNTRY = "pays";
        public static final String KEY_ROLES = "roles";
        public static final String KEY_CHARACTER_NAME = "characterName";
        public static final String KEY_ACTOR = "acteur";
        public static final String KEY_IDENTITY = "identite";
        public static final String KEY_BIRTH = "naissance";
        public static final String KEY_BIRTH_DATE = "dateNaissance";
        public static final String KEY_BIRTH_PLACE = "lieuNaissance";
        public static final String KEY_HEIGHT = "height";
        public static final String KEY_CITY = "ville";
        public static final String KEY_STATE_DEPARTMENT = "etatDept";
    }
}
