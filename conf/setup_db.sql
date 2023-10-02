CREATE DATABASE filmes_db;

USE filmes_db;

CREATE TABLE `filmes_db`.`new_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(250) NOT NULL,
  `duracao` INT NOT NULL,
  `ano` INT NOT NULL,
  `avaliacao` DOUBLE NOT NULL,
  PRIMARY KEY (`id`)
);