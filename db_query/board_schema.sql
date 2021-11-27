# board DB 생성
CREATE DATABASE board;

# board DB 사용
USE board;

# article table 생성
CREATE TABLE article (
    idx INT(5) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    `body` TEXT NOT NULL,
    nickname VARCHAR(50),
    regDate DATETIME # 게시물 등록일
);

DESC article;

INSERT INTO article SET title = 'aaa', `body` = 'bbb', nickname = 'ccc', regDate = '20211121103300';

SELECT *
FROM article;

# 게시물 수정 query
UPDATE article
SET title = 'kkk',
`body` = 'jjj'
WHERE idx = 5;
