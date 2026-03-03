package com.ndduroc.rocmovies.Config;

import java.util.List;

import net.datafaker.Faker;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;

public class MovieFactory {

    private static final Faker faker = new Faker();

    public static Movie create(List<Style> styles) {
        return new Movie(
            faker.movie().name(),
            faker.number().numberBetween(1, styles.size()),
            faker.number().numberBetween(1950, 2025),
            ""
        );
    }
}