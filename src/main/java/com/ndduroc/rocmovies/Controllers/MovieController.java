package com.ndduroc.rocmovies.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.entity.Movie;


@RestController

@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private IMovieService service;

    public MovieController(){}

    @GetMapping("/{id}")
    public Mono<Movie> getOneMovie(@PathVariable int id) {
        return service.getMovieById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "id incorrect")));
    }

    @GetMapping("")
    public Flux<Movie> getMoviesByStyle(@RequestParam Optional<Integer> style, Optional<Integer> old, Optional<Integer> late ){
        if(style.isPresent()){
            return service.getMoviesByStyleId(style.get());
        } else if(old.isPresent() && late.isPresent()) {
            return service.getMoviesBetween(old.get(), late.get());
        } else {
            return service.getListMovies();
        }
    }

    /*@PostMapping("")
    public Movie createMovie(@RequestBody Movie movie) {
        return service.addMovie(movie);
    }*/
}
