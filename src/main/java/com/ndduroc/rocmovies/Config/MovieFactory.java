package com.ndduroc.rocmovies.Config;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import net.datafaker.Faker;

import com.ndduroc.rocmovies.entity.Movie;
import com.ndduroc.rocmovies.entity.Style;

public class MovieFactory {

    private static final Faker faker = new Faker();

    private static final List<String> posters = List.of(
            "https://m.media-amazon.com/images/I/51NiGlapXlL._AC_.jpg", // The Shawshank Redemption
            "https://m.media-amazon.com/images/I/41+eK8zBwQL._AC_.jpg", // The Godfather
            "https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg", // Pulp Fiction
            "https://m.media-amazon.com/images/I/71niXI3lxlL._AC_SL1024_.jpg", // Interstellar
            "https://m.media-amazon.com/images/I/51oDs3IR4-L._AC_.jpg", // Inception
            "https://m.media-amazon.com/images/I/71c05lTE03L._AC_SL1024_.jpg", // The Dark Knight
            "https://m.media-amazon.com/images/I/81p+xe8cbnL._AC_SL1500_.jpg", // Avatar
            "https://m.media-amazon.com/images/I/81ai6zx6eXL._AC_SL1500_.jpg", // Avengers Endgame
            "https://m.media-amazon.com/images/I/91KkWf50SoL._AC_SL1500_.jpg", // Joker
            "https://m.media-amazon.com/images/I/81ExhpBEbHL._AC_SL1500_.jpg", // Avengers Infinity War
            "https://m.media-amazon.com/images/I/51rggtPgmRL._AC_.jpg", // Fight Club
            "https://m.media-amazon.com/images/I/51ZymOK7nGL._AC_.jpg", // Forrest Gump
            "https://m.media-amazon.com/images/I/51A9Zy1P5-L._AC_.jpg", // Gladiator
            "https://m.media-amazon.com/images/I/51o5dnjk07L._AC_.jpg", // The Matrix
            "https://m.media-amazon.com/images/I/81GqtNbs+PL._AC_SL1500_.jpg", // The Lion King
            "https://m.media-amazon.com/images/I/81GqtNbs+PL._AC_SL1500_.jpg", // Toy Story
            "https://m.media-amazon.com/images/I/81GqtNbs+PL._AC_SL1500_.jpg", // Titanic
            "https://m.media-amazon.com/images/I/71c05lTE03L._AC_SL1024_.jpg", // Batman Begins
            "https://m.media-amazon.com/images/I/81GqtNbs+PL._AC_SL1500_.jpg", // Monsters Inc
            "https://m.media-amazon.com/images/I/71c05lTE03L._AC_SL1024_.jpg", // The Prestige
            "https://m.media-amazon.com/images/I/81GqtNbs+PL._AC_SL1500_.jpg", // Ratatouille
            "https://m.media-amazon.com/images/I/51oDs3IR4-L._AC_.jpg", // Shutter Island
            "https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg", // Reservoir Dogs
            "https://m.media-amazon.com/images/I/51NiGlapXlL._AC_.jpg", // The Green Mile
            "https://m.media-amazon.com/images/I/41+eK8zBwQL._AC_.jpg", // Heat
            "https://m.media-amazon.com/images/I/51ZymOK7nGL._AC_.jpg", // Cast Away
            "https://m.media-amazon.com/images/I/51A9Zy1P5-L._AC_.jpg", // Braveheart
            "https://m.media-amazon.com/images/I/51rggtPgmRL._AC_.jpg", // Se7en
            "https://m.media-amazon.com/images/I/51o5dnjk07L._AC_.jpg", // The Truman Show
            "https://m.media-amazon.com/images/I/71niXI3lxlL._AC_SL1024_.jpg", // Arrival
            "https://m.media-amazon.com/images/I/81ai6zx6eXL._AC_SL1500_.jpg", // Dune
            "https://m.media-amazon.com/images/I/81p+xe8cbnL._AC_SL1500_.jpg", // The Revenant
            "https://m.media-amazon.com/images/I/91KkWf50SoL._AC_SL1500_.jpg", // La La Land
            "https://m.media-amazon.com/images/I/81ExhpBEbHL._AC_SL1500_.jpg", // Whiplash
            "https://m.media-amazon.com/images/I/51NiGlapXlL._AC_.jpg", // Prisoners
            "https://m.media-amazon.com/images/I/41+eK8zBwQL._AC_.jpg", // Nightcrawler
            "https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg", // Her
            "https://m.media-amazon.com/images/I/71niXI3lxlL._AC_SL1024_.jpg", // Drive
            "https://m.media-amazon.com/images/I/51oDs3IR4-L._AC_.jpg", // Sicario
            "https://m.media-amazon.com/images/I/71c05lTE03L._AC_SL1024_.jpg", // The Hateful Eight
            "https://m.media-amazon.com/images/I/81p+xe8cbnL._AC_SL1500_.jpg", // The Nice Guys
            "https://m.media-amazon.com/images/I/81ai6zx6eXL._AC_SL1500_.jpg", // Baby Driver
            "https://m.media-amazon.com/images/I/91KkWf50SoL._AC_SL1500_.jpg", // Knives Out
            "https://m.media-amazon.com/images/I/81ExhpBEbHL._AC_SL1500_.jpg", // Jojo Rabbit
            "https://m.media-amazon.com/images/I/51rggtPgmRL._AC_.jpg", // The Lighthouse
            "https://m.media-amazon.com/images/I/51ZymOK7nGL._AC_.jpg", // The Florida Project
            "https://m.media-amazon.com/images/I/51A9Zy1P5-L._AC_.jpg", // Moonlight
            "https://m.media-amazon.com/images/I/51o5dnjk07L._AC_.jpg", // Ex Machina
            "https://m.media-amazon.com/images/I/71niXI3lxlL._AC_SL1024_.jpg"  // The Witch
    );

    public static Movie create(List<Style> styles) {
        return new Movie(
            faker.movie().name(),
            faker.number().numberBetween(1, styles.size()),
            faker.number().numberBetween(1950, 2025),
            posters.get(ThreadLocalRandom.current().nextInt(posters.size()))
        );
    }
}