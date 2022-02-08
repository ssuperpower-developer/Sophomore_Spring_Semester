-- ------------------------------
-- 1절
-- ------------------------------

USE market_db;
DROP PROCEDURE IF EXISTS user_proc;
DELIMITER $$
CREATE PROCEDURE user_proc()
BEGIN
    SELECT * FROM member; -- 스토어드 프로시저 내용
END $$
DELIMITER ;

CALL user_proc();

DROP PROCEDURE user_proc;

USE market_db;
DROP PROCEDURE IF EXISTS user_proc1;
DELIMITER $$
CREATE PROCEDURE user_proc1(IN userName VARCHAR(10))
BEGIN
  SELECT * FROM member WHERE mem_name = userName; 
END $$
DELIMITER ;

CALL user_proc1('에이핑크');


DROP PROCEDURE IF EXISTS user_proc2;
DELIMITER $$
CREATE PROCEDURE user_proc2(
    IN userNumber INT, 
    IN userHeight INT  )
BEGIN
  SELECT * FROM member 
    WHERE mem_number > userNumber AND height > userHeight;
END $$
DELIMITER ;

CALL user_proc2(6, 165);


DROP PROCEDURE IF EXISTS user_proc3;
DELIMITER $$
CREATE PROCEDURE user_proc3(
    IN txtValue CHAR(10),
    OUT outValue INT     )
BEGIN
  INSERT INTO noTable VALUES(NULL,txtValue);
  SELECT MAX(id) INTO outValue FROM noTable; 
END $$
DELIMITER ;

DESC noTable;


CREATE TABLE IF NOT EXISTS noTable(
    id INT AUTO_INCREMENT PRIMARY KEY, 
    txt CHAR(10)
);

CALL user_proc3 ('테스트1', @myValue);
SELECT CONCAT('입력된 ID 값 ==>', @myValue);

DROP PROCEDURE IF EXISTS ifelse_proc;
DELIMITER $$
CREATE PROCEDURE ifelse_proc(
    IN memName VARCHAR(10)
)
BEGIN
    DECLARE debutYear INT; -- 변수 선언
    SELECT YEAR(debut_date) into debutYear FROM member
        WHERE mem_name = memName;
    IF (debutYear >= 2015) THEN
            SELECT '신인 가수네요. 화이팅 하세요.' AS '메시지';
    ELSE
            SELECT '고참 가수네요. 그동안 수고하셨어요.'AS '메시지';
    END IF;
END $$
DELIMITER ;

CALL ifelse_proc ('오마이걸');

SELECT YEAR(CURDATE()), MONTH(CURDATE()), DAY(CURDATE());


DROP PROCEDURE IF EXISTS while_proc;
DELIMITER $$
CREATE PROCEDURE while_proc()
BEGIN
    DECLARE hap INT; -- 합계
    DECLARE num INT; -- 1부터 100까지 증가
    SET hap = 0; -- 합계 초기화
    SET num = 1; 
    
    WHILE (num <= 100) DO  -- 100까지 반복.
        SET hap = hap + num;
        SET num = num + 1; -- 숫자 증가
    END WHILE;
    SELECT hap AS '1~100 합계';
END $$
DELIMITER ;

CALL while_proc();

DROP PROCEDURE IF EXISTS dynamic_proc;
DELIMITER $$
CREATE PROCEDURE dynamic_proc(
    IN tableName VARCHAR(20)
)
BEGIN
  SET @sqlQuery = CONCAT('SELECT * FROM ', tableName);
  PREPARE myQuery FROM @sqlQuery;
  EXECUTE myQuery;
  DEALLOCATE PREPARE myQuery;
END $$
DELIMITER ;

CALL dynamic_proc ('member');


-- ------------------------------
-- 2절
-- ------------------------------

SET GLOBAL log_bin_trust_function_creators = 1;

USE market_db;
DROP FUNCTION IF EXISTS sumFunc;
DELIMITER $$
CREATE FUNCTION sumFunc(number1 INT, number2 INT)
    RETURNS INT
BEGIN
    RETURN number1 + number2;
END $$
DELIMITER ;

SELECT sumFunc(100, 200) AS '합계';


DROP FUNCTION IF EXISTS calcYearFunc;
DELIMITER $$
CREATE FUNCTION calcYearFunc(dYear INT)
    RETURNS INT
BEGIN
    DECLARE runYear INT; -- 활동기간(연도)
    SET runYear = YEAR(CURDATE()) - dYear;
    RETURN runYear;
END $$
DELIMITER ;

SELECT calcYearFunc(2010) AS '활동햇수';

SELECT calcYearFunc(2007) INTO @debut2007;
SELECT calcYearFunc(2013) INTO @debut2013;
SELECT @debut2007-@debut2013 AS '2007과 2013 차이' ;

SELECT mem_id, mem_name, calcYearFunc(YEAR(debut_date)) AS '활동 햇수' 
    FROM member; 


SHOW CREATE FUNCTION calcYearFunc;

DROP FUNCTION calcYearFunc;


USE market_db;
DROP PROCEDURE IF EXISTS cursor_proc;
DELIMITER $$
CREATE PROCEDURE cursor_proc()
BEGIN
    DECLARE memNumber INT; -- 회원의 인원수
    DECLARE cnt INT DEFAULT 0; -- 읽은 행의 수
    DECLARE totNumber INT DEFAULT 0; -- 인원의 합계
    DECLARE endOfRow BOOLEAN DEFAULT FALSE; -- 행의 끝 여부(기본을 FALSE)

    DECLARE memberCuror CURSOR FOR-- 커서 선언
        SELECT mem_number FROM member;

    DECLARE CONTINUE HANDLER -- 행의 끝이면 endOfRow 변수에 TRUE를 대입 
        FOR NOT FOUND SET endOfRow = TRUE;

    OPEN memberCuror;  -- 커서 열기

    cursor_loop: LOOP
        FETCH  memberCuror INTO memNumber; 

        IF endOfRow THEN 
            LEAVE cursor_loop;
        END IF;

        SET cnt = cnt + 1;
        SET totNumber = totNumber + memNumber;        
    END LOOP cursor_loop;

    SELECT (totNumber/cnt) AS '회원의 평균 인원 수';

    CLOSE memberCuror; 
END $$
DELIMITER ;

CALL cursor_proc();


-- ------------------------------
-- 3절
-- ------------------------------

USE market_db;
CREATE TABLE IF NOT EXISTS trigger_table (id INT, txt VARCHAR(10));
INSERT INTO trigger_table VALUES(1, '레드벨벳');
INSERT INTO trigger_table VALUES(2, '잇지');
INSERT INTO trigger_table VALUES(3, '블랙핑크');

DROP TRIGGER IF EXISTS myTrigger;
DELIMITER $$ 
CREATE TRIGGER myTrigger  -- 트리거 이름
    AFTER  DELETE -- 삭제후에 작동하도록 지정
    ON trigger_table -- 트리거를 부착할 테이블
    FOR EACH ROW -- 각 행마다 적용시킴
BEGIN
    SET @msg = '가수 그룹이 삭제됨' ; -- 트리거 실행시 작동되는 코드들
END $$ 
DELIMITER ;

SET @msg = '';
INSERT INTO trigger_table VALUES(4, '마마무');
SELECT @msg;
UPDATE trigger_table SET txt = '블핑' WHERE id = 3;
SELECT @msg;

DELETE FROM trigger_table WHERE id = 4;
SELECT @msg;

USE market_db;
CREATE TABLE singer (SELECT mem_id, mem_name, mem_number, addr FROM member);

DROP TABLE IF EXISTS backup_singer;
CREATE TABLE backup_singer
( mem_id  		CHAR(8) NOT NULL , 
  mem_name    	VARCHAR(10) NOT NULL, 
  mem_number    INT NOT NULL, 
  addr	  		CHAR(2) NOT NULL,
  modType  CHAR(2), -- 변경된 타입. '수정' 또는 '삭제'
  modDate  DATE, -- 변경된 날짜
  modUser  VARCHAR(30) -- 변경한 사용자
);

DROP TRIGGER IF EXISTS singer_updateTrg;
DELIMITER $$
CREATE TRIGGER singer_updateTrg  -- 트리거 이름
    AFTER UPDATE -- 변경 후에 작동하도록 지정
    ON singer -- 트리거를 부착할 테이블
    FOR EACH ROW 
BEGIN
    INSERT INTO backup_singer VALUES( OLD.mem_id, OLD.mem_name, OLD.mem_number, 
        OLD.addr, '수정', CURDATE(), CURRENT_USER() );
END $$ 
DELIMITER ;

DROP TRIGGER IF EXISTS singer_deleteTrg;
DELIMITER $$
CREATE TRIGGER singer_deleteTrg  -- 트리거 이름
    AFTER DELETE -- 삭제 후에 작동하도록 지정
    ON singer -- 트리거를 부착할 테이블
    FOR EACH ROW 
BEGIN
    INSERT INTO backup_singer VALUES( OLD.mem_id, OLD.mem_name, OLD.mem_number, 
        OLD.addr, '삭제', CURDATE(), CURRENT_USER() );
END $$ 
DELIMITER ;


UPDATE singer SET addr = '영국' WHERE mem_id = 'BLK';
DELETE FROM singer WHERE mem_number >= 7;

SELECT * FROM backup_singer;

TRUNCATE TABLE singer;

SELECT * FROM backup_singer;


