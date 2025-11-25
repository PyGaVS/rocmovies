package com.ndduroc.rocmovies.Services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;

public interface IMovieService {

    List<Movie> getListMovies();

    Optional<Movie> getMovieById(int id);

    List<Movie> getMoviesByStyleId(int style);

    List<Movie> getMoviesBetween(int oldestYear, int latestYear);

    List<Movie> getMoviesByStyleBetween(int oldestYear, int latestYear, int style);

    Movie addMovie(Movie movie);
}