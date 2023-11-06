-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema shoes_store
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shoes_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shoes_store` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shoes_store` ;

-- -----------------------------------------------------
-- Table `shoes_store`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(10) NOT NULL,
  `email` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(30) NULL DEFAULT NULL,
  `adress` TEXT NOT NULL,
  `membership_status` TINYINT(1) NULL DEFAULT NULL,
  `last_activity_date` DATE NULL DEFAULT NULL,
  `is_user` TINYINT(1) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`category` (
  `CategoryName` VARCHAR(20) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CategoryName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`product` (
  `product_Id` VARCHAR(20) NOT NULL,
  `category_Name` VARCHAR(20) NULL DEFAULT NULL,
  `product_Name` VARCHAR(40) NOT NULL,
  `Size` INT NOT NULL,
  `num_Like` INT NULL DEFAULT NULL,
  `price` INT NOT NULL,
  `product_quantity` INT NOT NULL,
  `created_date` DATE NOT NULL,
  `sales_quantity` INT NULL DEFAULT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`product_Id`),
  INDEX `fk_product` (`category_Name` ASC) VISIBLE,
  CONSTRAINT `fk_product`
    FOREIGN KEY (`category_Name`)
    REFERENCES `shoes_store`.`category` (`CategoryName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`cart` (
  `cart_id` VARCHAR(20) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `product_id` VARCHAR(20) NOT NULL,
  `product_quantity` INT NOT NULL,
  `payment_status` TINYINT(1) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cart_id`),
  INDEX `fk_cart` (`user_id` ASC) VISIBLE,
  INDEX `fk_carts` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart`
    FOREIGN KEY (`user_id`)
    REFERENCES `shoes_store`.`user` (`user_id`),
  CONSTRAINT `fk_carts`
    FOREIGN KEY (`product_id`)
    REFERENCES `shoes_store`.`product` (`product_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`nonuser_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`nonuser_orders` (
  `order_Id` VARCHAR(15) NOT NULL,
  `product_Id` VARCHAR(20) NULL DEFAULT NULL,
  `final_price` INT NOT NULL,
  `order_Date` DATE NOT NULL,
  `comment` VARCHAR(3000) NULL DEFAULT NULL,
  `receiver` VARCHAR(300) NULL DEFAULT NULL,
  `adress` VARCHAR(300) NOT NULL,
  `phone` VARCHAR(300) NOT NULL,
  `postal_code` INT NOT NULL,
  `address_detail` VARCHAR(255) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`order_Id`),
  INDEX `fk_nonuser_orders` (`product_Id` ASC) VISIBLE,
  CONSTRAINT `fk_nonuser_orders`
    FOREIGN KEY (`product_Id`)
    REFERENCES `shoes_store`.`product` (`product_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`nonuser_orders_refund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`nonuser_orders_refund` (
  `refund_id` INT NOT NULL,
  `order_id` VARCHAR(20) NULL DEFAULT NULL,
  `buyer_reason` VARCHAR(30) NOT NULL,
  `seller_reason` VARCHAR(30) NOT NULL,
  `way` VARCHAR(30) NOT NULL,
  `adress` VARCHAR(1000) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`refund_id`),
  INDEX `fk_nonuser_orders_refund` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_nonuser_orders_refund`
    FOREIGN KEY (`order_id`)
    REFERENCES `shoes_store`.`nonuser_orders` (`order_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`review` (
  `user_id` VARCHAR(20) NOT NULL,
  `product_id` VARCHAR(20) NOT NULL,
  `size` INT NOT NULL,
  `rating` DOUBLE NOT NULL,
  `review_comment` TEXT NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  INDEX `fk_review_id` (`user_id` ASC) VISIBLE,
  INDEX `fk_product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `shoes_store`.`product` (`product_Id`),
  CONSTRAINT `fk_review_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `shoes_store`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`user_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`user_orders` (
  `order_Id` VARCHAR(15) NOT NULL,
  `user_Id` VARCHAR(15) NOT NULL,
  `product_Id` VARCHAR(20) NULL DEFAULT NULL,
  `final_price` INT NOT NULL,
  `order_Date` DATE NOT NULL,
  `comment` VARCHAR(3000) NULL DEFAULT NULL,
  `receiver` VARCHAR(300) NULL DEFAULT NULL,
  `adress` VARCHAR(300) NOT NULL,
  `phone` VARCHAR(300) NOT NULL,
  `postal_code` INT NOT NULL,
  `address_detail` VARCHAR(255) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`order_Id`),
  INDEX `fk_user` (`user_Id` ASC) VISIBLE,
  INDEX `fk_orders` (`product_Id` ASC) VISIBLE,
  CONSTRAINT `fk_orders`
    FOREIGN KEY (`product_Id`)
    REFERENCES `shoes_store`.`product` (`product_Id`),
  CONSTRAINT `fk_user`
    FOREIGN KEY (`user_Id`)
    REFERENCES `shoes_store`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`user_order_refund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`user_order_refund` (
  `refund_id` INT NOT NULL,
  `order_id` VARCHAR(20) NOT NULL,
  `buyer_reason` VARCHAR(30) NOT NULL,
  `seller_reason` VARCHAR(30) NOT NULL,
  `way` VARCHAR(30) NOT NULL,
  `adress` VARCHAR(1000) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`refund_id`),
  INDEX `fk_user_order_refund` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_order_refund`
    FOREIGN KEY (`order_id`)
    REFERENCES `shoes_store`.`user_orders` (`order_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
