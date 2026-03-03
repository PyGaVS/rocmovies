package com.ndduroc.rocmovies.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.Services.Interfaces.MovieRepository;
import com.ndduroc.rocmovies.Services.Interfaces.StyleRepository;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository repo;

    @Autowired
    private StyleRepository styleRepo;

    /** 
     * Liste complète de tous les films
     */
    @Override
    public Flux<Movie> getListMovies() {
        return repo.findAll().flatMap(movie -> 
            styleRepo.findById(movie.getStyleId()).map(style -> {
                movie.setStyle(style);
                return movie;
            })
        );
    }


    @Override
    public Mono<Movie> getMovieById(int id){
        return repo.findById(id).flatMap(movie -> 
            styleRepo.findById(movie.getStyleId()).map(style -> {
                movie.setStyle(style);
                return movie;
            })
        );
    }

    @Override
    public Flux<Movie> getMoviesByStyleId(int styleId){
        return repo.findByStyleId(styleId).flatMap(movie -> 
            styleRepo.findById(movie.getStyleId()).map(style -> {
                movie.setStyle(style);
                return movie;
            })
        );
    }

    @Override
    public Flux<Movie> getMoviesBetween(int oldestYear, int latestYear){
        return repo.findByProductionYearBetween(oldestYear, latestYear);
    }

    /* @Override
    public List<Movie> getMoviesByStyleBetween(int oldestYear, int latestYear, int style){
        return repo.findByStyleId(style).stream().filter(m -> m.getProductionYear() >= oldestYear && m.getProductionYear() <= latestYear).collect(Collectors.toList());
    } */

    public MovieService(){
        System.out.println("Création du service MovieService");
    }

    /*@Override
    public Movie addMovie(Movie movie) {

        return repo.save(movie);
    } */

    @Override
    public Flux<Style> getStyles() {
        return styleRepo.findAll();
    }
}
