package com.ndduroc.rocmovies.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ndduroc.rocmovies.Services.Interfaces.CustomerRepository;
import com.ndduroc.rocmovies.Services.Interfaces.MovieRepository;
import com.ndduroc.rocmovies.Services.Interfaces.StyleRepository;
import com.ndduroc.rocmovies.entity.Customer;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;

@Component
@Profile("dev")
public class DataSeeder implements CommandLineRunner {

    private final MovieRepository repo;
    private final StyleRepository styleRepo;
    private final CustomerRepository customerRepo;

    public DataSeeder(MovieRepository repo, StyleRepository styleRepo, CustomerRepository customerRepo) {
        this.repo = repo;
        this.styleRepo = styleRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public void run(String... args) {
        styleRepo.count()
        .flatMap(count -> {
            if (count == 0) {
                return styleRepo.saveAll(List.of(
                    new Style("SF"),
                    new Style("DRAME"),
                    new Style("THRILLER"),
                    new Style("ACTION")
                )).collectList();
            }
            return styleRepo.findAll().collectList();
        })
        .flatMapMany(styles -> {
            List<Movie> movies = new ArrayList<>(List.of(
                new Movie("Inception", styles.get(0).getId(), 2010,
                    "https://upload.wikimedia.org/wikipedia/en/2/2e/Inception_%282010%29_theatrical_poster.jpg"),
                new Movie("Gladiator", styles.get(3).getId(), 2000,
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/fb/Gladiator_%282000_film_poster%29.png/250px-Gladiator_%282000_film_poster%29.png"),
                new Movie("Titanic", styles.get(1).getId(), 1997,
                    "https://upload.wikimedia.org/wikipedia/en/thumb/1/18/Titanic_%281997_film%29_poster.png/250px-Titanic_%281997_film%29_poster.png"),
                new Movie("The Matrix", styles.get(0).getId(), 1999,
                    "https://upload.wikimedia.org/wikipedia/en/thumb/d/db/The_Matrix.png/250px-The_Matrix.png"),
                new Movie("The Godfather", styles.get(1).getId(), 1971,
                    "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg"),
                new Movie("Mad Max: Fury Road", styles.get(3).getId(), 2015,
                    "https://upload.wikimedia.org/wikipedia/en/6/6e/Mad_Max_Fury_Road.jpg"),
                new Movie("Se7en", styles.get(2).getId(), 1995,
                    "https://upload.wikimedia.org/wikipedia/en/6/68/Seven_%28movie%29_poster.jpg"),
                new Movie("Interstellar", styles.get(0).getId(), 2014,
                    "https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg"),
                new Movie("Joker", styles.get(1).getId(), 2019,
                    "https://upload.wikimedia.org/wikipedia/en/thumb/e/e1/Joker_%282019_film%29_poster.jpg/250px-Joker_%282019_film%29_poster.jpg"),
                new Movie("CONFRONTATION", styles.get(3).getId(), 1999,
                    "https://i.pinimg.com/736x/86/77/85/867785590fe46fddbdc3a31026f1e3f0.jpg"),
                new Movie("Die Hard", styles.get(3).getId(), 1988,
                    "https://upload.wikimedia.org/wikipedia/en/thumb/c/ca/Die_Hard_%281988_film%29_poster.jpg/250px-Die_Hard_%281988_film%29_poster.jpg")
            ));
        
            for (int i = 0; i < 100; i++) {
                movies.add(MovieFactory.create(styles));
            }
			styles.forEach(s -> System.out.println("Style: " + s.getId() + " - " + s.getName()));
            return repo.saveAll(movies);
        })
        .then()
        .flatMapMany(v -> customerRepo.saveAll(List.of(
            new Customer("Martin"),
            new Customer("Jules")
        )))
        .subscribe();
    }
}
