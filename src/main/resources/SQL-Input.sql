drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `itemId` INT NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `item_price` FLOAT DEFAULT NULL,
    PRIMARY KEY (`itemId`)
);

,
/* FOREIGN KEY (`order_item`) references `items`(`item_name`)*/
SHOW TABLES;

SELECT * FROM items;

DROP TABLE `items`; 

DROP TABLE `orders`;

CREATE TABLE IF NOT EXISTS `orders`(
`order_item` VARCHAR(40) DEFAULT NULL,
`order_no` INT NOT NULL AUTO_INCREMENT,
`order_id` INT NOT NULL,
`item_quantity` INT DEFAULT NULL,
 PRIMARY KEY (`order_no`),
 FOREIGN KEY (`order_id`) references `customers`(`id`)
 );
