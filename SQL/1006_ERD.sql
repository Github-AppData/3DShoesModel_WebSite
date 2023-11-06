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
-- Table `Graduation_WorkDB`.`shoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`shoes` (
  `shoes_Id` VARCHAR(1000) COLLATE 'utf8mb3_bin' NOT NULL,
  `shoes_Name` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `shoes_Price` INT NULL DEFAULT NULL,
  `num_Like` INT NULL DEFAULT '0',
  `cate_Name` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `revise_Date` DATETIME NULL DEFAULT NULL,
  `is_Like` TINYINT NULL DEFAULT '0',
  `brand_Name` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `color_Code` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`shoes_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`cart` (
  `cart_Id` INT NOT NULL,
  `user_Id` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `shoes_Id` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`cart_Id`),
  INDEX `fk_shoes_Id` (`shoes_Id` ASC) VISIBLE,
  CONSTRAINT `fk_shoes_Id`
    FOREIGN KEY (`shoes_Id`)
    REFERENCES `Graduation_WorkDB`.`shoes` (`shoes_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`delivery` (
  `delivery_Id` INT NOT NULL,
  `delivery_status` TINYINT NULL DEFAULT '0',
  `ship_num` VARCHAR(45) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`delivery_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`like_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`like_table` (
  `like_Id` INT NOT NULL AUTO_INCREMENT,
  `shoes_Id` VARCHAR(45) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`like_Id`),
  INDEX `fk_shoes_Id_likeTable` (`shoes_Id` ASC) VISIBLE,
  CONSTRAINT `fk_shoes_Id_likeTable`
    FOREIGN KEY (`shoes_Id`)
    REFERENCES `Graduation_WorkDB`.`shoes` (`shoes_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`notice_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`notice_board` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `content` VARCHAR(2048) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `write_date` DATETIME NULL DEFAULT NULL,
  `user_id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `is_delete` INT NULL DEFAULT '0',
  PRIMARY KEY (`idx`),
  INDEX `fk_user_id_notice_board_idx` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`order_List`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`order_List` (
  `order_Id` INT NOT NULL AUTO_INCREMENT,
  `user_Id` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `order_Date` DATE NULL DEFAULT NULL,
  `status` TINYINT NULL DEFAULT '0',
  `SalesPrice` INT NULL DEFAULT NULL,
  `RealPrice` INT NULL DEFAULT NULL,
  `Quantity` INT NULL DEFAULT '0',
  `delivery_Id` INT NULL DEFAULT NULL,
  `TotalPrice` INT NULL DEFAULT NULL,
  PRIMARY KEY (`order_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`purchase_shoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`purchase_shoes` (
  `order_Id` INT NULL DEFAULT NULL,
  `shoes_Id` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `purchase_Id` INT NULL DEFAULT NULL,
  INDEX `fk_order_Id_purchaseShoes_idx` (`order_Id` ASC) VISIBLE,
  INDEX `fk_shoes_Id_purchaseShoes` (`shoes_Id` ASC) VISIBLE,
  CONSTRAINT `fk_order_Id_purchaseShoes`
    FOREIGN KEY (`order_Id`)
    REFERENCES `Graduation_WorkDB`.`order_List` (`order_Id`),
  CONSTRAINT `fk_shoes_Id_purchaseShoes`
    FOREIGN KEY (`shoes_Id`)
    REFERENCES `Graduation_WorkDB`.`shoes` (`shoes_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`review` (
  `review_Id` INT NOT NULL,
  `order_Id` INT NULL DEFAULT NULL,
  `shoes_Id` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `user_Id` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `review_Writer` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `review_Title` VARCHAR(100) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `review_Content` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `Photo1` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `Photo2` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `review_Date` DATETIME NULL DEFAULT NULL,
  `review_Revise_Date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`review_Id`),
  INDEX `fk_order_Id_review_idx` (`order_Id` ASC) VISIBLE,
  INDEX `fk_shoes_Id_review` (`shoes_Id` ASC) VISIBLE,
  INDEX `fk_user_Idc_review_idx` (`user_Id` ASC) VISIBLE,
  CONSTRAINT `fk_order_Id_review`
    FOREIGN KEY (`order_Id`)
    REFERENCES `Graduation_WorkDB`.`order_List` (`order_Id`),
  CONSTRAINT `fk_shoes_Id_review`
    FOREIGN KEY (`shoes_Id`)
    REFERENCES `Graduation_WorkDB`.`shoes` (`shoes_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Graduation_WorkDB`.`shoes_size`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Graduation_WorkDB`.`shoes_size` (
  `size_Id` INT NOT NULL AUTO_INCREMENT,
  `shoes_Id` VARCHAR(1000) COLLATE 'utf8mb3_bin' NULL DEFAULT NULL,
  `shoes_Size` INT NULL DEFAULT NULL,
  `end_Size` INT NULL DEFAULT NULL,
  `shoes_Quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`size_Id`),
  INDEX `fk_shoes_id_shoesSize` (`shoes_Id` ASC) VISIBLE,
  CONSTRAINT `fk_shoes_id_shoesSize`
    FOREIGN KEY (`shoes_Id`)
    REFERENCES `Graduation_WorkDB`.`shoes` (`shoes_Id`))
ENGINE = InnoDB;


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
