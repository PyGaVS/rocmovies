package com.ndduroc.rocmovies.Services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ndduroc.rocmovies.Services.Interfaces.MovieRepository;
import com.ndduroc.rocmovies.entity.Movie;

import reactor.core.publisher.Flux;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class MovieServiceTest {

    // Bouchon
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setupAll(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"Test", 1, 2001, ""));
        movies.add(new Movie(2,"Test", 1, 2018, ""));
        movies.add(new Movie(3,"Test", 1, 2020, ""));
        movies.add(new Movie(4,"Test", 1, 20, ""));
        movies.add(new Movie(5,"Test", 1, 2009, ""));
        when(movieRepository.findAll()).thenReturn(Flux.fromIterable(movies));
    }
    
    // @Test
    // void testAddMovie() {
    // }

    /*@Test
    void testGetListMovies() {
        List<Movie> result = movieService.getListMovies();
        assertEquals(5, result.size());
    }*/

    // @Test
    // void testGetMovieById() {

    // }

    /*@Test
    public void testGetMoviesBetween() {
        int result = movieService.getMoviesBetween(2009, 2019).size();
        assertEquals(result, 2);
    }*/

    // @Test
    // void testGetMoviesByStyle() {

    // }
}
