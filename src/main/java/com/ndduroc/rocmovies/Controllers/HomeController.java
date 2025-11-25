package com.ndduroc.rocmovies.Controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.multi.MultiInternalFrameUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;


@Controller
public class HomeController {

    @Autowired
    private IMovieService service;

    @RequestMapping(value={"", "/", "home"})
    public String displayHomePage(Model model, @RequestParam Optional<Integer> style) {
        List<Movie> movies; 
        if(style.isPresent()){
            movies = service.getMoviesByStyleId(style.get());
        } else {
            movies = service.getListMovies();
        }
        model.addAttribute("movies", movies);
        model.addAttribute("movie_styles", Arrays.asList("SF", "ACTION", "THRILLER", "DRAME"));
        return "home.html";
    }

    @RequestMapping(value={"", "/{id}"})
    public String displayMovieDetailsPage(Model model, @PathVariable int id) {
        Optional<Movie> res = service.getMovieById(id);
        Movie movie;
        if(res.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id incorrect");
        } else {
            movie = res.get();
        }
        model.addAttribute("movie", movie);
        return "movieDetails.html";
    }
    
}
