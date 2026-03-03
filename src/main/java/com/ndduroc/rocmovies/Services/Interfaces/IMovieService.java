package com.ndduroc.rocmovies.Services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.ndduroc.rocmovies.entity.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovieService {

    Flux<Movie> getListMovies();

    Mono<Movie> getMovieById(int id);

    Flux<Movie> getMoviesByStyleId(int style);

    Flux<Movie> getMoviesBetween(int oldestYear, int latestYear);

    // List<Movie> getMoviesByStyleBetween(int oldestYear, int latestYear, int style);

    // Movie addMovie(Movie movie);
}