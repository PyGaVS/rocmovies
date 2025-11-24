package com.ndduroc.rocmovies.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

@Repository
public class MovieRepository {
    /**
     * Fournit une liste de films 'en dur' 
     * en attendant de pouvoir utiliser une base de données 
     * @return
     */
    private List<Movie> getDefaultList()
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
    public List<Movie> getListMovies(){
        if (movieList == null)
        {
            movieList = getDefaultList();
        }
        return movieList;
    }


    public Optional<Movie> getMovieById(long id){
        return getListMovies().stream().filter(m -> m.getIdMovie()==id).findFirst();
    }

    public Movie addMovie(Movie movie) {

        getListMovies().add(movie);
        return movie;
    }
    
}
