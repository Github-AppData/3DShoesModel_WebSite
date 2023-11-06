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
CREATE SCHEMA IF NOT EXISTS `Graduation_WorkDB` ;
USE `Graduation_WorkDB` ;

-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`cart` (
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
-- Table `Graduation_WorkDB`.`like_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`like_tb` (
  `like_Id` INT NOT NULL AUTO_INCREMENT,
  `shoes_id` VARCHAR(100) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `shoes_name` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `link_id` INT NOT NULL,
  PRIMARY KEY (`like_Id`),
  INDEX `fk_shoes_Id_likeTable` (`shoes_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 120;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`notice_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`notice_board` (
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
AUTO_INCREMENT = 29;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`order_List`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`order_List` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `shoes_id` VARCHAR(45) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `order_date` DATE NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT '0',
  `price` INT NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`review` (
  `review_id` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `shoes_id` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `rating` INT NOT NULL DEFAULT '0',
  `reviewText` VARCHAR(1000) CHARACTER SET 'utf8mb3' NOT NULL,
  PRIMARY KEY (`review_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`shoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`shoes` (
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
  UNIQUE INDEX `idx_UNIQUE` (`idx` ASC) VISIBLE,
  UNIQUE INDEX `shoes_Name_UNIQUE` (`shoes_name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 53;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`user` (
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

USE `Graduation_WorkDB` ;

-- -----------------------------------------------------
-- procedure AddShoeWithSizes
-- -----------------------------------------------------

DELIMITER $$
USE `Graduation_WorkDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddShoeWithSizes`(
	shoes_id VARCHAR(1000),
    shoes_name VARCHAR(500),
    cate_name varchar(100),
    brand_name VARCHAR(255),
    shoes_price INT,
    shoes_size INT,
    end_size INT,
    shoes_quantity INT

)
BEGIN
	DECLARE current_size INT;
    
    -- 루프를 사용하여 start_size부터 end_size까지 사이즈를 등록합니다.
    SET current_size = shoes_size;
    
    -- INSERT 문: 신발 정보 추가
        INSERT INTO shoes (shoes_id, cate_name, shoes_name, brand_name, shoes_price)
        VALUES (shoes_id, cate_name, shoes_name, brand_name, shoes_price);
        
    WHILE current_size <= end_size DO
        
        -- INSERT 문: 사이즈 정보 추가
        INSERT INTO shoes_size (shoes_id, shoes_size, end_size, shoes_quantity)
        VALUES (shoes_id, current_size, end_size, shoes_quantity);
        
        -- 다음 사이즈로 이동
        SET current_size = current_size + 10;
	END WHILE;

END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
