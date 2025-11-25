package com.ndduroc.rocmovies.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ndduroc.rocmovies.Services.Interfaces.CustomerRepository;
import com.ndduroc.rocmovies.Services.Interfaces.MovieRepository;
import com.ndduroc.rocmovies.Services.Interfaces.StyleRepository;
import com.ndduroc.rocmovies.entity.Customer;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;

@Component
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
        Style sF = styleRepo.save(new Style("SF"));
        Style drame = styleRepo.save(new Style("DRAME"));
        Style thriller = styleRepo.save(new Style("THRILLER"));
        Style action = styleRepo.save(new Style("ACTION"));

        if (repo.count() == 0) {
            repo.save(new Movie("Inception", sF, 2010, 
                "https://upload.wikimedia.org/wikipedia/en/2/2e/Inception_%282010%29_theatrical_poster.jpg"));
            repo.save(new Movie("Gladiator", action, 2000,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/fb/Gladiator_%282000_film_poster%29.png/250px-Gladiator_%282000_film_poster%29.png")); 
            repo.save(new Movie("Titanic", drame, 1997,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/1/18/Titanic_%281997_film%29_poster.png/250px-Titanic_%281997_film%29_poster.png"));  
            repo.save(new Movie("The Matrix", sF, 1999,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/d/db/The_Matrix.png/250px-The_Matrix.png"));  
            repo.save(new Movie("The Godfather", drame, 1971,  
                "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg"));  
            repo.save(new Movie("Mad Max: Fury Road", action, 2015,  
                "https://upload.wikimedia.org/wikipedia/en/6/6e/Mad_Max_Fury_Road.jpg"));  
            repo.save(new Movie("Se7en", thriller, 1995,  
                "https://upload.wikimedia.org/wikipedia/en/6/68/Seven_%28movie%29_poster.jpg"));  
            repo.save(new Movie("Interstellar", sF, 2014,  
                "https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg"));  
            repo.save(new Movie("Joker", drame, 2019,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/e/e1/Joker_%282019_film%29_poster.jpg/250px-Joker_%282019_film%29_poster.jpg"));
            repo.save(new Movie("CONFRONTATIIOON", action, 1999, 
                "https://i.pinimg.com/736x/86/77/85/867785590fe46fddbdc3a31026f1e3f0.jpg"));
            repo.save(new Movie("Die Hard", action, 1988,  
                "https://upload.wikimedia.org/wikipedia/en/thumb/c/ca/Die_Hard_%281988_film%29_poster.jpg/250px-Die_Hard_%281988_film%29_poster.jpg")); 
        }

        customerRepo.save(new Customer("martin"));
    }
}
