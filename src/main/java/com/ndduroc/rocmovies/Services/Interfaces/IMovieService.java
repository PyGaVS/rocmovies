package com.ndduroc.rocmovies.Services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

public interface IMovieService {

    List<Movie> getListMovies();

    Optional<Movie> getMovieById(int id);

    List<Movie> getMoviesByStyle(MovieStyles style);

    List<Movie> getMoviesBetween(int oldestYear, int latestYear);

    Movie addMovie(Movie movie);

}