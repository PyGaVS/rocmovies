package com.ndduroc.rocmovies.Services.Interfaces;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.ndduroc.rocmovies.entity.Borrow;


public interface BorrowRepository extends R2dbcRepository<Borrow, Integer>{}