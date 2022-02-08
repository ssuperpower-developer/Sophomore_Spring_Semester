-- ------------------------------
-- 1절
-- ------------------------------

USE market_db;
CREATE TABLE table1  (
    col1  INT  PRIMARY KEY,
    col2  INT,
    col3  INT
);
SHOW INDEX FROM table1;

CREATE TABLE table2  (
    col1  INT  PRIMARY KEY,
    col2  INT  UNIQUE,
    col3  INT  UNIQUE
);
SHOW INDEX FROM table2;

USE market_db;
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member 
( mem_id      CHAR(8) , 
  mem_name    VARCHAR(10),
  mem_number  INT ,  
  addr        CHAR(2)  
 );

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울');
SELECT * FROM member;

ALTER TABLE member
     ADD CONSTRAINT 
     PRIMARY KEY (mem_id);
SELECT * FROM member;

ALTER TABLE member DROP PRIMARY KEY ; -- 기본 키 제거
ALTER TABLE member 
    ADD CONSTRAINT 
    PRIMARY KEY(mem_name);
SELECT * FROM member;

INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울');
SELECT * FROM member;


USE market_db;
DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id      CHAR(8) , 
  mem_name    VARCHAR(10),
  mem_number  INT ,  
  addr        CHAR(2)  
 );

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울');
SELECT * FROM member;

ALTER TABLE member
     ADD CONSTRAINT 
     UNIQUE (mem_id);
SELECT * FROM member;

ALTER TABLE member
     ADD CONSTRAINT 
     UNIQUE (mem_name);
SELECT * FROM member;

INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울');
SELECT * FROM member;

-- ------------------------------
-- 2절
-- ------------------------------

USE market_db;
CREATE TABLE cluster  -- 클러스터형 테이블 
( mem_id      CHAR(8) , 
  mem_name    VARCHAR(10)
 );
INSERT INTO cluster VALUES('TWC', '트와이스');
INSERT INTO cluster VALUES('BLK', '블랙핑크');
INSERT INTO cluster VALUES('WMN', '여자친구');
INSERT INTO cluster VALUES('OMY', '오마이걸');
INSERT INTO cluster VALUES('GRL', '소녀시대');
INSERT INTO cluster VALUES('ITZ', '잇지');
INSERT INTO cluster VALUES('RED', '레드벨벳');
INSERT INTO cluster VALUES('APN', '에이핑크');
INSERT INTO cluster VALUES('SPC', '우주소녀');
INSERT INTO cluster VALUES('MMU', '마마무');

SELECT * FROM cluster;

ALTER TABLE cluster
    ADD CONSTRAINT 
    PRIMARY KEY (mem_id);

SELECT * FROM cluster;


USE market_db;
CREATE TABLE second  -- 보조 인덱스 테이블 
( mem_id      CHAR(8) , 
  mem_name    VARCHAR(10)
 );
INSERT INTO second VALUES('TWC', '트와이스');
INSERT INTO second VALUES('BLK', '블랙핑크');
INSERT INTO second VALUES('WMN', '여자친구');
INSERT INTO second VALUES('OMY', '오마이걸');
INSERT INTO second VALUES('GRL', '소녀시대');
INSERT INTO second VALUES('ITZ', '잇지');
INSERT INTO second VALUES('RED', '레드벨벳');
INSERT INTO second VALUES('APN', '에이핑크');
INSERT INTO second VALUES('SPC', '우주소녀');
INSERT INTO second VALUES('MMU', '마마무');

ALTER TABLE second
    ADD CONSTRAINT 
    UNIQUE (mem_id);

SELECT * FROM second;


-- ------------------------------
-- 3절
-- ------------------------------

USE market_db;
SELECT * FROM member;

SHOW INDEX FROM member;

SHOW TABLE STATUS LIKE 'member';

CREATE INDEX idx_member_addr 
   ON member (addr);

SHOW INDEX FROM member;

SHOW TABLE STATUS LIKE 'member';

ANALYZE TABLE member;
SHOW TABLE STATUS LIKE 'member';

CREATE UNIQUE INDEX idx_member_mem_number
    ON member (mem_number); -- 오류 발생

CREATE UNIQUE INDEX idx_member_mem_name
    ON member (mem_name);

SHOW INDEX FROM member;

INSERT INTO member VALUES('MOO', '마마무', 2, '태국', '001', '12341234', 155, '2020.10.10');

ANALYZE TABLE member;  -- 지금까지 만든 인덱스를 모두 적용
SHOW INDEX FROM member;


SELECT * FROM member;

SELECT mem_id, mem_name, addr FROM member;

SELECT mem_id, mem_name, addr 
    FROM member 
    WHERE mem_name = '에이핑크';
    
    
CREATE INDEX idx_member_mem_number
    ON member (mem_number);
ANALYZE TABLE member; -- 인덱스 적용

SELECT mem_name, mem_number 
    FROM member 
    WHERE mem_number >= 7; 
    
SELECT mem_name, mem_number 
    FROM member 
    WHERE mem_number >= 1; 
    
SELECT mem_name, mem_number 
    FROM member 
    WHERE mem_number*2 >= 14;     
    
SELECT mem_name, mem_number 
    FROM member 
    WHERE mem_number >= 14/2;   
    
SHOW INDEX FROM member;

DROP INDEX idx_member_mem_name ON member;
DROP INDEX idx_member_addr ON member;
DROP INDEX idx_member_mem_number ON member;

ALTER TABLE member 
    DROP PRIMARY KEY;


SELECT table_name, constraint_name
    FROM information_schema.referential_constraints
    WHERE constraint_schema = 'market_db';

ALTER TABLE buy 
    DROP FOREIGN KEY buy_ibfk_1;
ALTER TABLE member 
    DROP PRIMARY KEY;

    
SELECT mem_id, mem_name, mem_number, addr 
    FROM member 
    WHERE mem_name = '에이핑크';