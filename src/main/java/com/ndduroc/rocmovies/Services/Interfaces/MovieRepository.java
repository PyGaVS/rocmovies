package com.ndduroc.rocmovies.Services.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndduroc.rocmovies.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{}
