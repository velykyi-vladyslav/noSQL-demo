drop schema if exists `mydb`;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8;
USE `mydb`;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user`
(
    `id`              INT AUTO_INCREMENT NOT NULL,
    `name`            VARCHAR(45)        NULL,
    `surname`         VARCHAR(45)        NULL,
    `email`           VARCHAR(45)        NULL,
    `user_summary_id` INT UNIQUE         NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`user_summary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_summary`
(
    `id`             INT AUTO_INCREMENT NOT NULL,
    `date_of_birth`  DATE               NULL,
    `place_of_birth` VARCHAR(45)        NULL,
    `other_details`  VARCHAR(45)        NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB;

SELECT * FROM user;
SELECT * FROM user_summary;
