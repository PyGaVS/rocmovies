package com.ndduroc.rocmovies.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

@Service

public class MovieService2 implements IMovieService {


    /**
     * Fournit une liste de films 'en dur' 
     * en attendant de pouvoir utiliser une base de données 
     * @return
     */
    private static List<Movie> getDefaultList()
    {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"Cloud Atlas",MovieStyles.SF,2012));
        movies.add(new Movie(2,"Shutter Island",MovieStyles.THRILLER,2010));
        movies.add(new Movie(3,"Interstellar",MovieStyles.SF,2018));
        movies.add(new Movie(4,"Pulp Fiction",MovieStyles.ACTION,2001));
        movies.add(new Movie(5,"Mulholland Drive",MovieStyles.THRILLER,2001));
        
        return movies;
    }
    private List<Movie> movieList;

    /** 
     * Liste complète de tous les films
     */
    @Override
    public List<Movie> getListMovies(){
        if (movieList == null)
        {
            movieList = getDefaultList();
        }
        return movieList;
    }

    @Override
    public Optional<Movie> getMovieById(long id){
        return getListMovies().stream().filter(m -> m.getIdMovie()==id).findFirst();
    }

    @Override
    public List<Movie> getMoviesByStyle(MovieStyles style){
        return getListMovies().stream().filter(m -> m.getStyle() == style).collect(Collectors.toList());
    }



    public MovieService2(){
        System.out.println("Création du service MovieService");
    }

    
    @Override
    public Movie addMovie(Movie movie) {

        getListMovies().add(movie);
        return movie;
    }

    @Override
    public List<Movie> getMoviesBetween(int oldestYear, int latestYear){
        return getDefaultList();
    }
    
}
