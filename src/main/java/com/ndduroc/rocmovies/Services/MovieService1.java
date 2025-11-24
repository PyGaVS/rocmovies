package com.ndduroc.rocmovies.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.Repositories.MovieRepository;
import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

@Service
@Primary

public class MovieService1 implements IMovieService {

    @Autowired 
    private MovieRepository movieRepo;
    /** 
     * Liste complète de tous les films
     */
    @Override
    public List<Movie> getListMovies(){
        return movieRepo.getListMovies();
    }


    @Override
    public Optional<Movie> getMovieById(long id){
        return movieRepo.getMovieById(id);
    }

    @Override
    public List<Movie> getMoviesByStyle(MovieStyles style){
        return movieRepo.getListMovies().stream().filter(m -> m.getStyle() == style).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesBetween(int oldestYear, int latestYear){
        return movieRepo.getListMovies().stream().filter(m -> m.getProductionYear() >= oldestYear && m.getProductionYear() <= latestYear).collect(Collectors.toList());
    }

    public MovieService1(){
        System.out.println("Création du service MovieService");
    }

    @Override
    public Movie addMovie(Movie movie) {

        return movieRepo.addMovie(movie);
    }
}
