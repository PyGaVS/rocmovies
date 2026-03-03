package com.ndduroc.rocmovies;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;

public class utils {

    public static List<Style> getStylesFromMovies(List<Movie> movies) {
        Map<Integer, Style> styles = new LinkedHashMap<>();
        for (Movie movie : movies) {
            styles.putIfAbsent(movie.getStyleId(), movie.getStyle());
        }
        return new ArrayList<>(styles.values());
    }
}
