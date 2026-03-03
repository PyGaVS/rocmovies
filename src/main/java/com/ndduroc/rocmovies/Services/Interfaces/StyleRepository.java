package com.ndduroc.rocmovies.Services.Interfaces;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.ndduroc.rocmovies.entity.Style;


public interface StyleRepository extends R2dbcRepository<Style, Integer>{}