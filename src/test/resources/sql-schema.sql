DROP SCHEMA IF EXISTS ims;

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
`orderID` INT NOT NULL AUTO_INCREMENT,
`customerID` INT NOT NULL,
PRIMARY KEY (`orderID`),
FOREIGN KEY (`customerID`) REFERENCES customers(`id`) ON DELETE CASCADE
);
 
 SELECT *
FROM `orders`;

CREATE TABLE IF NOT EXISTS `orderRequest` (
  `orderRequestID` INT NOT NULL AUTO_INCREMENT,
  `orderID` INT NOT NULL,
  `itemId` INT NOT NULL,
  `quantity` INT NOT NULL,
   PRIMARY KEY (`orderRequestID`),
   FOREIGN KEY (`itemId`) References items(`itemId`)
   ON DELETE CASCADE,
  FOREIGN KEY (`orderID`) references orders(`orderID`)
   ON DELETE CASCADE) ;

SELECT *
FROM orderRequest;

DROP TABLE `orderRequest`;

 
 


