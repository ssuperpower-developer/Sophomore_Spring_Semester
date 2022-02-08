-- ------------------------------
-- 1절
-- ------------------------------

USE market_db;
CREATE TABLE hongong4 (
    tinyint_col  TINYINT,
    smallint_col SMALLINT,
    int_col    INT,
    bigint_col BIGINT );

INSERT INTO hongong4 VALUES(127, 32767, 2147483647, 9000000000000000000);

INSERT INTO hongong4 VALUES(128, 32768, 2147483648, 90000000000000000000);

DROP TABLE IF EXISTS buy, member;
CREATE TABLE member -- 회원 테이블
( mem_id      CHAR(8) NOT NULL PRIMARY KEY, -- 회원 아이디(PK)
  mem_name        VARCHAR(10) NOT NULL, -- 이름
  mem_number    INT NOT NULL,  -- 인원수
  addr          CHAR(2) NOT NULL, -- 주소(경기,서울,경남 식으로 2글자만입력)
  phone1        CHAR(3), -- 연락처의 국번(02, 031, 055 등)
  phone2        CHAR(8), -- 연락처의 나머지 전화번호(하이픈제외)
  height        SMALLINT,  -- 평균 키
  debut_date    DATE  -- 데뷔 일자
);

DROP TABLE IF EXISTS member;
CREATE TABLE member -- 회원 테이블
( mem_id      CHAR(8) NOT NULL PRIMARY KEY, -- 회원 아이디(PK)
  mem_name        VARCHAR(10) NOT NULL, -- 이름
  mem_number    TINYINT  NOT NULL,  -- 인원수
  addr          CHAR(2) NOT NULL, -- 주소(경기,서울,경남 식으로 2글자만입력)
  phone1        CHAR(3), -- 연락처의 국번(02, 031, 055 등)
  phone2        CHAR(8), -- 연락처의 나머지 전화번호(하이픈제외)
  height        TINYINT UNSIGNED,  -- 평균 키
  debut_date    DATE  -- 데뷔 일자
);


DROP TABLE IF EXISTS member;
CREATE TABLE member -- 회원 테이블
( mem_id      CHAR(8) NOT NULL PRIMARY KEY, -- 회원 아이디(PK)
  mem_name        VARCHAR(10) NOT NULL, -- 이름
  mem_number    TINYINT  NOT NULL,  -- 인원수
  addr          CHAR(2) NOT NULL, -- 주소(경기,서울,경남 식으로 2글자만입력)
  phone1        CHAR(3), -- 연락처의 국번(02, 031, 055 등)
  phone2        CHAR(8), -- 연락처의 나머지 전화번호(하이픈제외)
  height        TINYINT UNSIGNED,  -- 평균 키
  debut_date    DATE  -- 데뷔 일자
);

CREATE TABLE big_table (
  data1  CHAR(255),
  data2  VARCHAR(16384) );

CREATE DATABASE netflix_db;
USE netflix_db;
CREATE TABLE movie 
  (movie_id        INT,
   movie_title     VARCHAR(30),
   movie_director  VARCHAR(20),
   movie_star      VARCHAR(20),
   movie_script    LONGTEXT,
   movie_film      LONGBLOB
); 


USE market_db;
SET @myVar1 = 5 ;
SET @myVar2 = 4.25 ;

SELECT @myVar1 ;
SELECT @myVar1 + @myVar2 ;

SET @txt = '가수 이름==> ' ;
SET @height = 166;
SELECT @txt , mem_name FROM member WHERE height > @height ;


SET @count = 3;
SELECT mem_name, height FROM member ORDER BY height LIMIT @count;

SET @count = 3;
PREPARE mySQL FROM 'SELECT mem_name, height FROM member ORDER BY height LIMIT ?';
EXECUTE mySQL USING @count;

SELECT AVG(price) '평균 가격' FROM buy;

SELECT CAST(AVG(price) AS SIGNED)  '평균 가격'  FROM buy ;
-- 또는
SELECT CONVERT(AVG(price) , SIGNED)  '평균 가격'  FROM buy ;

SELECT CAST('2022$12$12' AS DATE);
SELECT CAST('2022/12/12' AS DATE);
SELECT CAST('2022%12%12' AS DATE);
SELECT CAST('2022@12@12' AS DATE);

SELECT num, CONCAT(CAST(price AS CHAR), 'X', CAST(amount AS CHAR) ,'=' ) '가격X수량',
    price*amount '구매액' 
  FROM buy ;

SELECT '100' + '200' ; -- 문자와 문자를 더함 (정수로 변환되서 연산됨)
SELECT CONCAT('100', '200'); -- 문자와 문자를 연결 (문자로 처리)
SELECT CONCAT(100, '200'); -- 정수와 문자를 연결 (정수가 문자로 변환되서 처리)
SELECT 1 > '2mega'; -- 정수인 2로 변환되어서 비교
SELECT 3 > '2MEGA'; -- 정수인 2로 변환되어서 비교
SELECT 0 = 'mega2'; -- 문자는 0으로 변환됨

-- ------------------------------
-- 2절
-- ------------------------------

USE market_db;
SELECT * 
   FROM buy
     INNER JOIN member
     ON buy.mem_id = member.mem_id
   WHERE buy.mem_id = 'GRL';

SELECT * 
   FROM buy
     INNER JOIN member
     ON buy.mem_id = member.mem_id;
     
SELECT mem_id, mem_name, prod_name, addr, CONCAT(phone1, phone2) AS '연락처' 
   FROM buy
     INNER JOIN member
     ON buy.mem_id = member.mem_id;

SELECT buy.mem_id, mem_name, prod_name, addr, CONCAT(phone1, phone2) AS '연락처' 
   FROM buy
     INNER JOIN member
     ON buy.mem_id = member.mem_id;


SELECT B.mem_id, M.mem_name, B.prod_name, M.addr, 
        CONCAT(M.phone1, M.phone2) AS '연락처' 
   FROM buy B
     INNER JOIN member M
     ON B.mem_id = M.mem_id;
          
SELECT M.mem_id, M.mem_name, B.prod_name, M.addr
   FROM buy B
     INNER JOIN member M
     ON B.mem_id = M.mem_id
   ORDER BY M.mem_id;

SELECT DISTINCT M.mem_id, M.mem_name, M.addr
   FROM buy B
     INNER JOIN member M
     ON B.mem_id = M.mem_id
   ORDER BY M.mem_id;
   
SELECT M.mem_id, M.mem_name, B.prod_name, M.addr
   FROM member M
     LEFT OUTER JOIN buy B
     ON M.mem_id = B.mem_id
   ORDER BY M.mem_id;

SELECT M.mem_id, M.mem_name, B.prod_name, M.addr
   FROM buy B
     RIGHT OUTER JOIN member M
     ON M.mem_id = B.mem_id
   ORDER BY M.mem_id;
   
SELECT DISTINCT M.mem_id, B.prod_name, M.mem_name, M.addr
   FROM member M
     LEFT OUTER JOIN buy B
     ON M.mem_id = B.mem_id
   WHERE B.prod_name IS NULL
   ORDER BY M.mem_id;

SELECT * 
   FROM buy 
     CROSS JOIN member ;

SELECT COUNT(*) "데이터 개수"
   FROM sakila.inventory
      CROSS JOIN world.city;

SELECT COUNT(*) "데이터 개수"
   FROM sakila.inventory
      CROSS JOIN world.city;

CREATE TABLE cross_table
    SELECT *
       FROM sakila.actor
          CROSS JOIN world.country;

SELECT * FROM cross_table LIMIT 5;

USE market_db;
CREATE TABLE emp_table (emp CHAR(4), manager CHAR(4), phone VARCHAR(8));

INSERT INTO emp_table VALUES('대표', NULL, '0000');
INSERT INTO emp_table VALUES('영업이사', '대표', '1111');
INSERT INTO emp_table VALUES('관리이사', '대표', '2222');
INSERT INTO emp_table VALUES('정보이사', '대표', '3333');
INSERT INTO emp_table VALUES('영업과장', '영업이사', '1111-1');
INSERT INTO emp_table VALUES('경리부장', '관리이사', '2222-1');
INSERT INTO emp_table VALUES('인사부장', '관리이사', '2222-2');
INSERT INTO emp_table VALUES('개발팀장', '정보이사', '3333-1');
INSERT INTO emp_table VALUES('개발주임', '정보이사', '3333-1-1');

SELECT A.emp "직원" , B.emp "직속상관", B.phone "직속상관연락처"
   FROM emp_table A
      INNER JOIN emp_table B
         ON A.manager = B.emp
   WHERE A.emp = '경리부장';

-- ------------------------------
-- 3절
-- ------------------------------

DROP PROCEDURE IF EXISTS ifProc1; -- 기존에 만든적이 있다면 삭제
DELIMITER $$
CREATE PROCEDURE ifProc1()
BEGIN
   IF 100 = 100 THEN  
      SELECT '100은 100과 같습니다.';
   END IF;
END $$
DELIMITER ;
CALL ifProc1();


DROP PROCEDURE IF EXISTS ifProc2; 
DELIMITER $$
CREATE PROCEDURE ifProc2()
BEGIN
   DECLARE myNum INT;  -- myNum 변수선언
   SET myNum = 200;  -- 변수에 값 대입
   IF myNum = 100 THEN  
      SELECT '100입니다.';
   ELSE
      SELECT '100이 아닙니다.';
   END IF;
END $$
DELIMITER ;
CALL ifProc2();


DROP PROCEDURE IF EXISTS ifProc3; 
DELIMITER $$
CREATE PROCEDURE ifProc3()
BEGIN
    DECLARE debutDate DATE; -- 데뷰일
    DECLARE curDate DATE; -- 오늘
    DECLARE days INT; -- 활동한 일수

    SELECT debut_date INTO debutDate -- debut_date 결과를 hireDATE에 대입
       FROM market_db.member
       WHERE mem_id = 'APN';

    SET curDATE = CURRENT_DATE(); -- 현재 날짜
    SET days =  DATEDIFF(curDATE, debutDate); -- 날짜의 차이, 일 단위

    IF (days/365) >= 5 THEN -- 5년이 지났다면
          SELECT CONCAT('데뷔한지 ', days, '일이나 지났습니다. 핑순이들 축하합니다!');
    ELSE
          SELECT '데뷔한지 ' + days + '일밖에 안되었네요. 핑순이들 화이팅~' ;
    END IF;
END $$
DELIMITER ;
CALL ifProc3();

SELECT CURRENT_DATE(), DATEDIFF('2021-12-31', '2000-1-1');

DROP PROCEDURE IF EXISTS caseProc; 
DELIMITER $$
CREATE PROCEDURE caseProc()
BEGIN
    DECLARE point INT ;
    DECLARE credit CHAR(1);
    SET point = 88 ;
    
    CASE 
        WHEN point >= 90 THEN
            SET credit = 'A';
        WHEN point >= 80 THEN
            SET credit = 'B';
        WHEN point >= 70 THEN
            SET credit = 'C';
        WHEN point >= 60 THEN
            SET credit = 'D';
        ELSE
            SET credit = 'F';
    END CASE;
    SELECT CONCAT('취득점수==>', point), CONCAT('학점==>', credit);
END $$
DELIMITER ;
CALL caseProc();


SELECT mem_id, SUM(price*amount) "총구매액"
   FROM buy
   GROUP BY mem_id;
   
SELECT mem_id, SUM(price*amount) "총구매액"
   FROM buy
   GROUP BY mem_id
   ORDER BY SUM(price*amount) DESC ;

SELECT B.mem_id, M.mem_name, SUM(price*amount) "총구매액"
   FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id
   GROUP BY B.mem_id
   ORDER BY SUM(price*amount) DESC ;


SELECT M.mem_id, M.mem_name, SUM(price*amount) "총구매액"
   FROM buy B
         RIGHT OUTER JOIN member M
         ON B.mem_id = M.mem_id
   GROUP BY M.mem_id
   ORDER BY SUM(price*amount) DESC ;
   

SELECT M.mem_id, M.mem_name, SUM(price*amount) "총구매액",
        CASE  
           WHEN (SUM(price*amount)  >= 1500) THEN '최우수고객'
           WHEN (SUM(price*amount)  >= 1000) THEN '우수고객'
           WHEN (SUM(price*amount) >= 1 ) THEN '일반고객'
           ELSE '유령고객'
        END "회원등급"
   FROM buy B
         RIGHT OUTER JOIN member M
         ON B.mem_id = M.mem_id
   GROUP BY M.mem_id
   ORDER BY SUM(price*amount) DESC ;
   
DROP PROCEDURE IF EXISTS whileProc; 
DELIMITER $$
CREATE PROCEDURE whileProc()
BEGIN
    DECLARE i INT; -- 1에서 100까지 증가할 변수
    DECLARE hap INT; -- 더한 값을 누적할 변수
    SET i = 1;
    SET hap = 0;

    WHILE (i <= 100) DO
        SET hap = hap + i;  -- hap의 원래의 값에 i를 더해서 다시 hap에 넣으라는 의미
        SET i = i + 1;      -- i의 원래의 값에 1을 더해서 다시 i에 넣으라는 의미
    END WHILE;

    SELECT '1부터 100까지의 합 ==>', hap;   
END $$
DELIMITER ;
CALL whileProc();


DROP PROCEDURE IF EXISTS whileProc2; 
DELIMITER $$
CREATE PROCEDURE whileProc2()
BEGIN
    DECLARE i INT; -- 1에서 100까지 증가할 변수
    DECLARE hap INT; -- 더한 값을 누적할 변수
    SET i = 1;
    SET hap = 0;

    myWhile: 
    WHILE (i <= 100) DO  -- While문에 label을 지정
       IF (i%4 = 0) THEN
         SET i = i + 1;     
         ITERATE myWhile; -- 지정한 label문으로 가서 계속 진행
       END IF;
       SET hap = hap + i; 
       IF (hap > 1000) THEN 
         LEAVE myWhile; -- 지정한 label문을 떠남. 즉, While 종료.
       END IF;
       SET i = i + 1;
    END WHILE;

    SELECT '1부터 100까지의 합(4의 배수 제외), 1000 넘으면 종료 ==>', hap; 
END $$
DELIMITER ;
CALL whileProc2();


use market_db;
PREPARE myQuery FROM 'SELECT * FROM member WHERE mem_id = "BLK"';
EXECUTE myQuery;
DEALLOCATE PREPARE myQuery;


DROP TABLE IF EXISTS gate_table;
CREATE TABLE gate_table (id INT AUTO_INCREMENT PRIMARY KEY, entry_time DATETIME);

SET @curDate = CURRENT_TIMESTAMP(); -- 현재 날짜와 시간

PREPARE myQuery FROM 'INSERT INTO gate_table VALUES(NULL, ?)';
EXECUTE myQuery USING @curDate;
DEALLOCATE PREPARE myQuery;

SELECT * FROM gate_table;

