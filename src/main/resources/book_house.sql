CREATE DATABASE book_house;
USE book_house;
CREATE TABLE `t_pixabay` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(16) DEFAULT NULL,
  `tags` VARCHAR(64) DEFAULT NULL,
  `views` INT DEFAULT NULL,
  `downloads` INT DEFAULT NULL,
  `collections` INT DEFAULT NULL,
  `likes` INT DEFAULT NULL,
  `comments` INT DEFAULT NULL,
  `add_time` DATE DEFAULT NULL,
  `page_url` VARCHAR(512) DEFAULT NULL,
  `image_width` INT DEFAULT NULL,
  `image_height` INT DEFAULT NULL,
  `image_size` INT DEFAULT NULL,
  `large_image_url` VARCHAR(512) DEFAULT NULL,
  `preview_width` INT DEFAULT NULL,
  `preview_height` INT DEFAULT NULL,
  `preview_url` VARCHAR(512) DEFAULT NULL,
  `web_format_width` INT DEFAULT NULL,
  `web_format_height` INT DEFAULT NULL,
  `web_format_url` VARCHAR(512) DEFAULT NULL,
  `user_id` INT DEFAULT NULL,
  `user` VARCHAR(64) DEFAULT NULL,
  `user_image_url` VARCHAR(512) DEFAULT NULL,
  CONSTRAINT pk_pixabay_id PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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