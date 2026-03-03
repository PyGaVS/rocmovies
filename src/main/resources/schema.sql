CREATE TABLE IF NOT EXISTS styles (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customers (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS movies (
    id_movie INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    production_year INT,
    style_id INT NOT NULL,
    image VARCHAR(255),
    PRIMARY KEY (id_movie),
    FOREIGN KEY (style_id) REFERENCES styles(id)
);

CREATE TABLE IF NOT EXISTS borrows (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    date DATETIME(6),
    customer_id INT NOT NULL,
    movie_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id_movie)
);