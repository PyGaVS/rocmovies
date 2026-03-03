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
import reactor.core.publisher.Mono;


@Controller
public class HomeController {

    @Autowired
    private IMovieService service;

    @RequestMapping(value = {"", "/", "home"})
    public Mono<String> displayHomePage(Model model, @RequestParam Optional<Integer> style) {
        if (style.isPresent()) {
            return service.getMoviesByStyleId(style.get())
                .collectList()
                .map(movies -> {
                    model.addAttribute("movies", movies);
                    return "home.html";
                });
        }
        return service.getListMovies()
            .collectList()
            .map(movies -> {
                model.addAttribute("movies", movies);
                return "home.html";
            }
        );
    }

    @RequestMapping("/movie-details/{id}")
    public Mono<String> displayMovieDetailsPage(Model model, @PathVariable int id) {
        return service.getMovieById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "id incorrect"))).map(movie -> {
            model.addAttribute("movie", movie);
            return "movieDetails.html";
        });
    }

}
