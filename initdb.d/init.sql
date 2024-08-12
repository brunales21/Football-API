CREATE DATABASE if not exists football;

USE football;

CREATE TABLE player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    nationality VARCHAR(50),
    team VARCHAR(50)
);

