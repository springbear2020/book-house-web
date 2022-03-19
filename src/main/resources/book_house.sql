CREATE DATABASE book_house;

USE book_house;

CREATE TABLE `t_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(128) NOT NULL,
  `register_date` DATE NOT NULL,
  `score` INT NOT NULL,
  CONSTRAINT pk_user_id  PRIMARY KEY (`id`),
  CONSTRAINT uniq_username  UNIQUE KEY (`username`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;