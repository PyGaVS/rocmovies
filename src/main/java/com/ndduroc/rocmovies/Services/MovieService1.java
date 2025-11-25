package com.ndduroc.rocmovies.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.Services.Interfaces.MovieRepository;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

@Service
@Primary
public class MovieService1 implements IMovieService {

    @Autowired 
    private MovieRepository repo;
    
    /** 
     * Liste complète de tous les films
     */
    @Override
    public List<Movie> getListMovies(){
        return repo.findAll();
    }


    @Override
    public Optional<Movie> getMovieById(int id){
        return repo.findById(id);
    }

    @Override
    public List<Movie> getMoviesByStyle(MovieStyles style){
        return repo.findAll().stream().filter(m -> m.getStyle() == style).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesBetween(int oldestYear, int latestYear){
        return repo.findAll().stream().filter(m -> m.getProductionYear() >= oldestYear && m.getProductionYear() <= latestYear).collect(Collectors.toList());
    }

    public MovieService1(){
        System.out.println("Création du service MovieService");
    }

    @Override
    public Movie addMovie(Movie movie) {

        return repo.save(movie);
    }
}
