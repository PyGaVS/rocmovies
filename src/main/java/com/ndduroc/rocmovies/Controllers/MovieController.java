package com.ndduroc.rocmovies.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController

@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private IMovieService service;

    public MovieController(){
        //this.service = new MovieService();
    }

    @GetMapping("/{id}")
    public Movie getOneMovie(@PathVariable int id) {
        Optional<Movie> res = service.getMovieById(id);
        if(res.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id incorrect");
        } else {
            return res.get();
        }

        
    }

    @GetMapping("")
    public List<Movie> getMoviesByStyle(@RequestParam Optional<Integer> style, Optional<Integer> old, Optional<Integer> late ){  
        if(style.isPresent()){
            return service.getMoviesByStyleId(style.get());
        } else if(old.isPresent() && late.isPresent()) {
            return service.getMoviesBetween(old.get(), late.get());
        } else {
            return service.getListMovies();
        }
    }

    @PostMapping("")
    public Movie createMovie(@RequestBody Movie movie) {
        return service.addMovie(movie);

    }
}
