CREATE SCHEMA IF NOT EXISTS `spring`;

CREATE TABLE IF NOT EXISTS `spring`.`user`
(
    `username` VARCHAR(45) NOT NULL,
    `password` TEXT NOT NULL,
    PRIMARY KEY (`username`)
    );

CREATE TABLE IF NOT EXISTS `spring`.`authority`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY(`id`)
    );

CREATE TABLE IF NOT EXISTS `spring`.`user_authorities`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `authority` INT NOT NULL,
    `user` VARCHAR(45) NOT NULL,
    CONSTRAINT `authority`
    FOREIGN KEY (`authority`)
        REFERENCES `spring`.`authority`(`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `fk_user_authority`
    FOREIGN KEY (`user`)
        REFERENCES `spring`.`user`(`username`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    PRIMARY KEY(`id`)
    );

CREATE TABLE IF NOT EXISTS `spring`.`product`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `price` DOUBLE(5, 2),
    PRIMARY KEY(`id`)
    );

CREATE TABLE IF NOT EXISTS `spring`.`currency` (
    `currency` VARCHAR(3) NOT NULL,
    PRIMARY KEY(`currency`)
    );

CREATE TABLE `spring`.`user_products`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `user` VARCHAR(45) NOT NULL,
    `product` INT NOT NULL,
    `currency` VARCHAR(3) NOT NULL,
    CONSTRAINT `fk_user_product`
        FOREIGN KEY(`user`)
        REFERENCES `spring`.`user`(`username`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `product` FOREIGN KEY(`product`)
        REFERENCES `spring`.`product`(`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `currency` FOREIGN KEY(`currency`)
        REFERENCES `spring`.`currency`(`currency`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    PRIMARY KEY(`id`)
);