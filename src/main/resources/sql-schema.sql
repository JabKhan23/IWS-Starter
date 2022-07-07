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
    `item_price` DOUBLE NOT NULL,
    PRIMARY KEY (`itemId`)
);


/* FOREIGN KEY (`order_item`) references `items`(`item_name`)*/
SHOW TABLES;

SELECT * FROM items;

DROP TABLE `items`; 

DROP TABLE `orders`;

CREATE TABLE IF NOT EXISTS `orders`(
`orderID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`itemID` int,
`customerID` INT,


CONSTRAINT FOREIGN KEY (customerID) references customers(id) ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY (itemID) references items (itemId) ON DELETE CASCADE
 );
 
 SELECT *
FROM `orders`;


