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
-- Table `shoes_store`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`category` (
  `category_name` VARCHAR(20) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`shoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`shoes` (
  `shoes_id` VARCHAR(255) NOT NULL,
  `category_name` VARCHAR(20) NULL DEFAULT NULL,
  `brand_name` VARCHAR(40) NOT NULL,
  `shoes_name` VARCHAR(40) NOT NULL,
  `num_like` INT NULL DEFAULT NULL,
  `price` INT NOT NULL,
  `product_quantity` INT NOT NULL,
  `sales_quantity` INT NULL DEFAULT NULL,
  `created_date` DATE NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  PRIMARY KEY (`shoes_id`),
  INDEX `fk_shoes_category_name` (`category_name` ASC) VISIBLE,
  CONSTRAINT `fk_shoes_category_name`
    FOREIGN KEY (`category_name`)
    REFERENCES `shoes_store`.`category` (`category_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`user` (
  `id` VARCHAR(20) NOT NULL,
  `pw` VARCHAR(40) NOT NULL,
  `name` VARCHAR(10) NOT NULL,
  `email` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(30) NULL DEFAULT NULL,
  `adress` TEXT NOT NULL,
  `membership_status` TINYINT(1) NULL DEFAULT NULL,
  `last_activity_date` DATE NULL DEFAULT NULL,
  `is_user` TINYINT(1) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`cart` (
  `cart_id` VARCHAR(20) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `shoes_id` VARCHAR(255) NOT NULL,
  `shoes_quantity` INT NOT NULL,
  `payment_status` TINYINT(1) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` DATETIME NOT NULL,
  PRIMARY KEY (`cart_id`),
  INDEX `fk_cart_user_id` (`user_id` ASC) VISIBLE,
  INDEX `fk_cart_shoes_id` (`shoes_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart_shoes_id`
    FOREIGN KEY (`shoes_id`)
    REFERENCES `shoes_store`.`shoes` (`shoes_id`),
  CONSTRAINT `fk_cart_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `shoes_store`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`coupon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`coupon` (
  `coupon_id` VARCHAR(20) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `coupon_name` VARCHAR(20) NOT NULL,
  `discount_percent` INT NULL DEFAULT NULL,
  `is_coupon` TINYINT(1) NOT NULL,
  `column_insert_date` DATETIME NULL DEFAULT NULL,
  `column_modified_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`coupon_id`),
  INDEX `fk_coupon_user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_coupon_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `shoes_store`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`nonuser_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`nonuser_orders` (
  `order_id` VARCHAR(15) NOT NULL,
  `shoes_id` VARCHAR(255) NULL DEFAULT NULL,
  `total_price` INT NOT NULL,
  `order_date` DATETIME NOT NULL,
  `orders_comment` VARCHAR(3000) NULL DEFAULT NULL,
  `receiver` VARCHAR(300) NULL DEFAULT NULL,
  `phone` VARCHAR(300) NOT NULL,
  `adress` VARCHAR(300) NOT NULL,
  `address_detail` VARCHAR(255) NOT NULL,
  `postal_code` INT NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_nonuser_orders_shoes_id` (`shoes_id` ASC) VISIBLE,
  CONSTRAINT `fk_nonuser_orders_shoes_id`
    FOREIGN KEY (`shoes_id`)
    REFERENCES `shoes_store`.`shoes` (`shoes_id`))
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
  `column_insert_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`refund_id`),
  INDEX `fk_nonuser_orders_refund_user_id` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_nonuser_orders_refund_user_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `shoes_store`.`nonuser_orders` (`order_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`review` (
  `user_id` VARCHAR(20) NOT NULL,
  `shoes_id` VARCHAR(255) NULL DEFAULT NULL,
  `size` INT NOT NULL,
  `rating` DOUBLE NOT NULL,
  `review_comment` TEXT NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `review_date` DATETIME NOT NULL,
  INDEX `fk_review_user_id` (`user_id` ASC) VISIBLE,
  INDEX `fk_review_shoes_id` (`shoes_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_shoes_id`
    FOREIGN KEY (`shoes_id`)
    REFERENCES `shoes_store`.`shoes` (`shoes_id`),
  CONSTRAINT `fk_review_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `shoes_store`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`shoes_size`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`shoes_size` (
  `shoes_id` VARCHAR(255) NOT NULL,
  `size` INT NOT NULL,
  `column_insert_date` DATETIME NULL DEFAULT NULL,
  `column_modified_date` DATETIME NULL DEFAULT NULL,
  INDEX `fk_shoes_size_shoes_id` (`shoes_id` ASC) VISIBLE,
  CONSTRAINT `fk_shoes_size_shoes_id`
    FOREIGN KEY (`shoes_id`)
    REFERENCES `shoes_store`.`shoes` (`shoes_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`user_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`user_orders` (
  `order_id` VARCHAR(15) NOT NULL,
  `user_id` VARCHAR(15) NOT NULL,
  `shoes_id` VARCHAR(255) NULL DEFAULT NULL,
  `final_price` INT NOT NULL,
  `order_date` DATE NOT NULL,
  `orders_comment` VARCHAR(3000) NULL DEFAULT NULL,
  `receiver` VARCHAR(300) NULL DEFAULT NULL,
  `phone` VARCHAR(300) NOT NULL,
  `adress` VARCHAR(300) NOT NULL,
  `address_detail` VARCHAR(255) NOT NULL,
  `postal_code` INT NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_user_orders_user_id` (`user_id` ASC) VISIBLE,
  INDEX `fk_user_orders_shoes_id` (`shoes_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_orders_shoes_id`
    FOREIGN KEY (`shoes_id`)
    REFERENCES `shoes_store`.`shoes` (`shoes_id`),
  CONSTRAINT `fk_user_orders_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `shoes_store`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shoes_store`.`user_orders_refund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_store`.`user_orders_refund` (
  `refund_id` INT NOT NULL,
  `order_id` VARCHAR(20) NOT NULL,
  `buyer_reason` VARCHAR(30) NOT NULL,
  `seller_reason` VARCHAR(30) NOT NULL,
  `way` VARCHAR(30) NOT NULL,
  `adress` VARCHAR(1000) NOT NULL,
  `column_modified_date` DATETIME NOT NULL,
  `column_insert_date` DATETIME NOT NULL,
  PRIMARY KEY (`refund_id`),
  INDEX `fk_user_order_refund_order_id` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_order_refund_order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `shoes_store`.`user_orders` (`order_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
