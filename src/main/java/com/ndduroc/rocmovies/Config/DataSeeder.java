package com.ndduroc.rocmovies.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ndduroc.rocmovies.Services.Interfaces.MovieRepository;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

@Component
public class DataSeeder implements CommandLineRunner {

    private final MovieRepository repo;

    public DataSeeder(MovieRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            repo.save(new Movie("Inception", MovieStyles.SF, 2010,  
                "https://upload.wikimedia.org/wikipedia/en/2/2e/Inception_%282010%29_theatrical_poster.jpg"));
            repo.save(new Movie("Gladiator", MovieStyles.ACTION, 2000,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/fb/Gladiator_%282000_film_poster%29.png/250px-Gladiator_%282000_film_poster%29.png")); 
            repo.save(new Movie("Titanic", MovieStyles.DRAME, 1997,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/1/18/Titanic_%281997_film%29_poster.png/250px-Titanic_%281997_film%29_poster.png"));  
            repo.save(new Movie("The Matrix", MovieStyles.SF, 1999,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/d/db/The_Matrix.png/250px-The_Matrix.png"));  
            repo.save(new Movie("The Godfather", MovieStyles.DRAME, 1972,  
                "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg"));  
            repo.save(new Movie("Mad Max: Fury Road", MovieStyles.ACTION, 2015,  
                "https://upload.wikimedia.org/wikipedia/en/6/6e/Mad_Max_Fury_Road.jpg"));  
            repo.save(new Movie("Se7en", MovieStyles.THRILLER, 1995,  
                "https://upload.wikimedia.org/wikipedia/en/6/68/Seven_%28movie%29_poster.jpg"));  
            repo.save(new Movie("Interstellar", MovieStyles.SF, 2014,  
                "https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg"));  
            repo.save(new Movie("Joker", MovieStyles.DRAME, 2019,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/e/e1/Joker_%282019_film%29_poster.jpg/250px-Joker_%282019_film%29_poster.jpg"));
            repo.save(new Movie("CONFRONTATIIOON", MovieStyles.ACTION, 1999, 
                "https://i.pinimg.com/736x/86/77/85/867785590fe46fddbdc3a31026f1e3f0.jpg"));
            repo.save(new Movie("Die Hard", MovieStyles.ACTION, 1988,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/c/ca/Die_Hard_%281988_film%29_poster.jpg/250px-Die_Hard_%281988_film%29_poster.jpg")); 
        }
    }
}
