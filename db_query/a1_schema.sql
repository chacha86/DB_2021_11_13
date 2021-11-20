# 개념/개체 -> table / 엔터티
# 속성 -> 컬럼
# 튜플, 레코드 -> 로우

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

INSERT INTO t_addr SET `name` = '홍길동', address = '대전', phone = '010-1111-2222';

SELECT *
FROM t_addr;


