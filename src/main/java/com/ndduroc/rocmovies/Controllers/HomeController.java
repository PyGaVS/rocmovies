package com.ndduroc.rocmovies.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndduroc.rocmovies.Services.Interfaces.IMovieService;
import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;


@Controller
public class HomeController {

    @Autowired
    private IMovieService service;

    @RequestMapping(value={"", "/", "home"})
    public String displayHomePage(Model model, @RequestParam Optional<MovieStyles> style) {
        List<Movie> movies = new ArrayList<Movie>(); 
        if(style.isPresent()){
            movies = service.getMoviesByStyle(style.get());
        } else {
            movies = service.getListMovies();
        }
        model.addAttribute("movies", movies);
        model.addAttribute("movie_styles", Arrays.asList("SF", "ACTION", "THRILLER"));
        return "home.html";
    }
    
}
