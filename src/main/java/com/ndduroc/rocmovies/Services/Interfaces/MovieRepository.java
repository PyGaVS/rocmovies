package com.ndduroc.rocmovies.Services.Interfaces;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.ndduroc.rocmovies.entity.Movie;

import reactor.core.publisher.Flux;

public interface MovieRepository extends R2dbcRepository<Movie, Integer> {
    Flux<Movie> findByStyleId(int styleId);

    Flux<Movie> findByProductionYearBetween(int oldestYear, int latestYear);
}
