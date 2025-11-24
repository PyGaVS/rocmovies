package com.ndduroc.rocmovies.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.MovieStyles;

@Repository
public class MovieRepositoryJDBC {

    private Connection connection;

    /**
     * Fournit une liste de films 'en dur' 
     * en attendant de pouvoir utiliser une base de données 
     * @return
     */
    public MovieRepositoryJDBC()
    {
        try {
            this.connection = DriverManager.getConnection("127.0.0.1:3306", "root", "pwroot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Movie> movieList;

    /** 
     * Liste complète de tous les films
     */
    public List<Movie> getListMovies(){
        String sql = "SELECT * FROM movies";
        Statement statement;
        List<Movie> movies = new ArrayList<>();
        try {
            statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }


    public Optional<Movie> getMovieById(long id){
        return getListMovies().stream().filter(m -> m.getIdMovie()==id).findFirst();
    }

    public Movie addMovie(Movie movie) {

        getListMovies().add(movie);
        return movie;
    }
}
