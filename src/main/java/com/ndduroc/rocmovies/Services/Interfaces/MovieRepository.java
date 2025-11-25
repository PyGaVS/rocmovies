package com.ndduroc.rocmovies.Services.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;


public interface MovieRepository extends JpaRepository<Movie, Integer>{
    List<Movie> findByStyleId(int styleId);
}
