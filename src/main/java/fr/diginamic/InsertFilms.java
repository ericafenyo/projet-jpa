package fr.diginamic;

import fr.diginamic.data.Imdb;
import fr.diginamic.di.ServiceLoader;
import fr.diginamic.services.MovieService;

import java.io.IOException;

public class InsertFilms {
    public static void main(String[] args) throws IOException {
        Imdb imdb = Imdb.create();
        MovieService service = ServiceLoader.load(MovieService.class);
        service.save(imdb.getMovies());
    }
}
