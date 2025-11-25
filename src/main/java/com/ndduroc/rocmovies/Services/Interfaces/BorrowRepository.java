package com.ndduroc.rocmovies.Services.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndduroc.rocmovies.entity.Borrow;


public interface BorrowRepository extends JpaRepository<Borrow, Integer>{}