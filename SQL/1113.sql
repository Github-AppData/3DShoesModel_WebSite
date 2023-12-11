-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Graduation_WorkDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Graduation_WorkDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Graduation_WorkDB_S` ;
USE `Graduation_WorkDB_S` ;

-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`cart` (
  `cart_Id` INT NOT NULL AUTO_INCREMENT,
  `user_Id` VARCHAR(100) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `shoes_Id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `size` INT NULL DEFAULT NULL,
  `is_delete` INT NULL DEFAULT '0',
  PRIMARY KEY (`cart_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`like_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`like_tb` (
  `like_Id` INT NOT NULL AUTO_INCREMENT,
  `shoes_id` VARCHAR(100) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `shoes_name` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `link_id` INT NOT NULL,
  `user_id` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  PRIMARY KEY (`like_Id`),
  INDEX `fk_shoes_Id_likeTable` (`shoes_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 146;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`main`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`main` (
  `idx` VARCHAR(45) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `shoes_id` VARCHAR(100) COLLATE 'utf8mb3_bin' NOT NULL,
  `shoes_name` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `final_price` INT NOT NULL,
  PRIMARY KEY (`shoes_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`notice_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`notice_board` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `content` VARCHAR(2048) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `write_date` DATE NULL DEFAULT NULL,
  `views` INT NULL DEFAULT '0',
  `user_id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `is_delete` INT NULL DEFAULT '0',
  PRIMARY KEY (`idx`),
  INDEX `fk_user_id_notice_board_idx` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 30;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`order_List`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`order_List` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `shoes_name` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT '0',
  `price` INT NULL DEFAULT NULL,
  `size` INT NULL DEFAULT NULL,
  `user_id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `order_date` DATE NULL DEFAULT NULL,
  `way` VARCHAR(45) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`review` (
  `review_id` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `shoes_id` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `rating` INT NOT NULL DEFAULT '0',
  `reviewText` VARCHAR(1000) CHARACTER SET 'utf8mb3' NOT NULL,
  PRIMARY KEY (`review_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`shoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`shoes` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `shoes_id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NOT NULL,
  `shoes_name` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `shoes_price` INT NULL DEFAULT '0',
  `sales` INT NULL DEFAULT '0',
  `is_Like` INT NULL DEFAULT '0',
  `is_delete` INT NULL DEFAULT '0',
  `final_price` INT NULL DEFAULT NULL,
  `review_stars` INT NULL DEFAULT '0',
  PRIMARY KEY (`shoes_id`),
  UNIQUE INDEX `shoes_Name_UNIQUE` (`shoes_name` ASC) VISIBLE,
  UNIQUE INDEX `idx_UNIQUE` (`idx` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 13;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`test` (
  `idx` VARCHAR(45) CHARACTER SET 'utf8mb4' NOT NULL,
  `shoes_id` VARCHAR(1000) CHARACTER SET 'utf8mb4' NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idx`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB_S`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB_S`.`user` (
  `user_id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NOT NULL,
  `idx` INT NOT NULL AUTO_INCREMENT,
  `pw` VARCHAR(400) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `adress` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `Detail_adress` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `email` VARCHAR(100) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `salt` VARCHAR(100) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Phone` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `Birthday` DATE NOT NULL,
  `is_Status` INT NULL DEFAULT '0',
  `name` VARCHAR(45) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `idx_UNIQUE` (`idx` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 10;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
