-- ------------------------------
-- 1절
-- ------------------------------

CREATE DATABASE naver_db;

CREATE TABLE sample_table (num INT);

DROP DATABASE IF EXISTS naver_db;
CREATE DATABASE naver_db;

USE naver_db;
DROP TABLE IF EXISTS member;  -- 기존에 있으면 삭제
CREATE TABLE member -- 회원 테이블
( mem_id        CHAR(8), -- 회원 아이디(PK)
  mem_name      VARCHAR(10), -- 이름
  mem_number    TINYINT,  -- 인원수
  addr          CHAR(2), -- 주소(경기,서울,경남 식으로 2글자만입력)
  phone1        CHAR(3), -- 연락처의 국번(02, 031, 055 등)
  phone2        CHAR(8), -- 연락처의 나머지 전화번호(하이픈제외)
  height        TINYINT UNSIGNED,  -- 평균 키
  debut_date    DATE  -- 데뷔 일자
);

DROP TABLE IF EXISTS member;  -- 기존에 있으면 삭제
CREATE TABLE member -- 회원 테이블
( mem_id        CHAR(8) NOT NULL,
  mem_name      VARCHAR(10) NOT NULL, 
  mem_number    TINYINT NOT NULL, 
  addr          CHAR(2) NOT NULL,
  phone1        CHAR(3) NULL,
  phone2        CHAR(8) NULL,
  height        TINYINT UNSIGNED NULL, 
  debut_date    DATE NULL
);

DROP TABLE IF EXISTS member;  -- 기존에 있으면 삭제
CREATE TABLE member -- 회원 테이블
( mem_id        CHAR(8) NOT NULL PRIMARY KEY,
  mem_name      VARCHAR(10) NOT NULL, 
  mem_number    TINYINT NOT NULL, 
  addr          CHAR(2) NOT NULL,
  phone1        CHAR(3) NULL,
  phone2        CHAR(8) NULL,
  height        TINYINT UNSIGNED NULL, 
  debut_date    DATE NULL
);

DROP TABLE IF EXISTS buy;  -- 기존에 있으면 삭제
CREATE TABLE buy -- 구매 테이블
(  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   mem_id      CHAR(8) NOT NULL, -- 아이디(FK)
   prod_name     CHAR(6) NOT NULL, --  제품이름
   group_name     CHAR(4) NULL , -- 분류
   price         INT UNSIGNED NOT NULL, -- 가격
   amount        SMALLINT UNSIGNED  NOT NULL -- 수량
);

DROP TABLE IF EXISTS buy;  -- 기존에 있으면 삭제
CREATE TABLE buy 
(  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   mem_id      CHAR(8) NOT NULL, 
   prod_name     CHAR(6) NOT NULL, 
   group_name     CHAR(4) NULL ,
   price         INT UNSIGNED NOT NULL,
   amount        SMALLINT UNSIGNED  NOT NULL ,
   FOREIGN KEY(mem_id) REFERENCES member(mem_id)
);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015-10-19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016-8-8');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015-1-15');

INSERT INTO buy VALUES( NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES( NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES( NULL, 'APN', '아이폰', '디지털', 200, 1);


-- ------------------------------
-- 2절
-- ------------------------------

USE naver_db;
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL
);

DESCRIBE member;

DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL,
  PRIMARY KEY (mem_id)
);

DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL
);
ALTER TABLE member
     ADD CONSTRAINT 
     PRIMARY KEY (mem_id);


DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL,
  CONSTRAINT PRIMARY KEY PK_member_mem_id (mem_id)
);

DROP TABLE IF EXISTS buy, member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL
);
CREATE TABLE buy 
(  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   mem_id      CHAR(8) NOT NULL, 
   prod_name     CHAR(6) NOT NULL, 
   FOREIGN KEY(mem_id) REFERENCES member(mem_id)
);

DROP TABLE IF EXISTS buy, member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL
);
CREATE TABLE buy 
(  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   user_id      CHAR(8) NOT NULL, 
   prod_name     CHAR(6) NOT NULL, 
   FOREIGN KEY(user_id) REFERENCES member(mem_id)
);

DROP TABLE IF EXISTS buy;
CREATE TABLE buy 
(  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   mem_id      CHAR(8) NOT NULL, 
   prod_name     CHAR(6) NOT NULL
);
ALTER TABLE buy
    ADD CONSTRAINT 
    FOREIGN KEY(mem_id) REFERENCES member(mem_id);

INSERT INTO member VALUES('BLK', '블랙핑크', 163);
INSERT INTO buy VALUES(NULL, 'BLK', '지갑');
INSERT INTO buy VALUES(NULL, 'BLK', '맥북');

SELECT M.mem_id, M.mem_name, B.prod_name 
   FROM buy B
      INNER JOIN member M
      ON B.mem_id = M.mem_id;
      
UPDATE member SET mem_id = 'PINK' WHERE mem_id='BLK';

DELETE FROM member WHERE  mem_id='BLK';

DROP TABLE IF EXISTS buy;
CREATE TABLE buy 
(  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   mem_id      CHAR(8) NOT NULL, 
   prod_name     CHAR(6) NOT NULL
);
ALTER TABLE buy
    ADD CONSTRAINT 
    FOREIGN KEY(mem_id) REFERENCES member(mem_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;
    
INSERT INTO buy VALUES(NULL, 'BLK', '지갑');
INSERT INTO buy VALUES(NULL, 'BLK', '맥북');

UPDATE member SET mem_id = 'PINK' WHERE mem_id='BLK';

SELECT M.mem_id, M.mem_name, B.prod_name 
   FROM buy B
      INNER JOIN member M
      ON B.mem_id = M.mem_id;

DELETE FROM member WHERE  mem_id='PINK';

SELECT * FROM buy;

DROP TABLE IF EXISTS buy, member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL,
  email       CHAR(30)  NULL UNIQUE
);

INSERT INTO member VALUES('BLK', '블랙핑크', 163, 'pink@gmail.com');
INSERT INTO member VALUES('TWC', '트와이스', 167, NULL);
INSERT INTO member VALUES('APN', '에이핑크', 164, 'pink@gmail.com');
SELECT * FROM member;

DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL CHECK (height >= 100),
  phone1      CHAR(3)  NULL
);

INSERT INTO member VALUES('BLK', '블랙핑크', 163, NULL);
INSERT INTO member VALUES('TWC', '트와이스', 99, NULL);

ALTER TABLE member
    ADD CONSTRAINT 
    CHECK  (phone1 IN ('02', '031', '032', '054', '055', '061' )) ;

INSERT INTO member VALUES('TWC', '트와이스', 167, '02');
INSERT INTO member VALUES('OMY', '오마이걸', 167, '010');

DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL DEFAULT 160,
  phone1      CHAR(3)  NULL
);

ALTER TABLE member
    ALTER COLUMN phone1 SET DEFAULT '02';

INSERT INTO member VALUES('RED', '레드벨벳', 161, '054');
INSERT INTO member VALUES('SPC', '우주소녀', default, default);
SELECT * FROM member;


-- ------------------------------
-- 3절
-- ------------------------------

USE market_db;
SELECT mem_id, mem_name, addr FROM member;

USE market_db;
CREATE VIEW v_member
AS
    SELECT mem_id, mem_name, addr FROM member;

SELECT * FROM v_member;

SELECT mem_name, addr FROM v_member
   WHERE addr IN ('서울', '경기');

SELECT B.mem_id, M.mem_name, B.prod_name, M.addr, 
        CONCAT(M.phone1, M.phone2) '연락처' 
   FROM buy B
     INNER JOIN member M
     ON B.mem_id = M.mem_id;

CREATE VIEW v_memberbuy
AS
    SELECT B.mem_id, M.mem_name, B.prod_name, M.addr, 
            CONCAT(M.phone1, M.phone2) '연락처' 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;

SELECT * FROM v_memberbuy WHERE mem_name = '블랙핑크';

USE market_db;
CREATE VIEW v_viewtest1
AS
    SELECT B.mem_id 'Member ID', M.mem_name AS 'Member Name', 
            B.prod_name "Product Name", 
            CONCAT(M.phone1, M.phone2) AS "Office Phone" 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;
         
SELECT  DISTINCT `Member ID`, `Member Name` FROM v_viewtest1; -- 백틱을 사용

ALTER VIEW v_viewtest1
AS
    SELECT B.mem_id '회원 아이디', M.mem_name AS '회원 이름', 
            B.prod_name "제품 이름", 
            CONCAT(M.phone1, M.phone2) AS "연락처" 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;
         
SELECT  DISTINCT `회원 아이디`, `회원 이름` FROM v_viewtest1;  -- 백틱을 사용

DROP VIEW v_viewtest1;

USE market_db;
CREATE OR REPLACE VIEW v_viewtest2
AS
    SELECT mem_id, mem_name, addr FROM member;

DESCRIBE v_viewtest2;

DESCRIBE member;

SHOW CREATE VIEW v_viewtest2;

UPDATE v_member SET addr = '부산' WHERE mem_id='BLK' ;

INSERT INTO v_member(mem_id, mem_name, addr) VALUES('BTS','방탄소년단','경기') ;

CREATE VIEW v_height167
AS
    SELECT * FROM member WHERE height >= 167 ;
    
SELECT * FROM v_height167 ;

DELETE FROM v_height167 WHERE height < 167;

INSERT INTO v_height167 VALUES('TRA','티아라', 6, '서울', NULL, NULL, 159, '2005-01-01') ;

SELECT * FROM v_height167;

ALTER VIEW v_height167
AS
    SELECT * FROM member WHERE height >= 167
        WITH CHECK OPTION ;
        
INSERT INTO v_height167 VALUES('TOB','텔레토비', 4, '영국', NULL, NULL, 140, '1995-01-01') ;

CREATE VIEW v_complex
AS
    SELECT B.mem_id, M.mem_name, B.prod_name, M.addr
        FROM buy B
            INNER JOIN member M
            ON B.mem_id = M.mem_id;

DROP TABLE IF EXISTS buy, member;

SELECT * FROM v_height167;

CHECK TABLE v_height167;

