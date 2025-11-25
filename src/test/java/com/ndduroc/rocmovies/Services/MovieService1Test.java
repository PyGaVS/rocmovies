package com.ndduroc.rocmovies.Services;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ndduroc.rocmovies.Repositories.MovieRepositoryy;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

@ExtendWith(MockitoExtension.class)
public class MovieService1Test {

    // Bouchon
    @Mock
    private MovieRepositoryy movieRepository;

    @InjectMocks
    private MovieService1 movieService;

    @BeforeEach
    public void setupAll(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"Test", MovieStyles.ACTION, 2001, ""));
        movies.add(new Movie(2,"Test", MovieStyles.ACTION, 2018, ""));
        movies.add(new Movie(3,"Test", MovieStyles.ACTION, 2020, ""));
        movies.add(new Movie(4,"Test", MovieStyles.ACTION, 20, ""));
        movies.add(new Movie(5,"Test", MovieStyles.ACTION, 2009, ""));
        when(movieRepository.getListMovies()).thenReturn(movies);
    }

    @Test
    void testAddMovie() {
    }

    @Test
    void testGetListMovies() {

    }

    @Test
    void testGetMovieById() {

    }

    @Test
    public void testGetMoviesBetween() {
        int result = movieService.getMoviesBetween(2009, 2019).size();
        assertEquals(result, 2);
    }

    @Test
    void testGetMoviesByStyle() {

    }
}
