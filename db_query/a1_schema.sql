# 개념/개체 -> table

CREATE DATABASE a1;

USE a1;

SHOW TABLES;

CREATE TABLE t_addr (
    idx INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,   
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL
);

DESC t_addr;

