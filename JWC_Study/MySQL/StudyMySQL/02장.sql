-- ------------------------------
-- 1절
-- ------------------------------

SHOW DATABASES

-- ------------------------------
-- 2절
-- ------------------------------

SELECT * FROM member;

SELECT member_name, member_addr FROM member;

SELECT * FROM member WHERE member_name = '아이유' ;

-- ------------------------------
-- 3절
-- ------------------------------

SELECT * FROM member WHERE member_name = '아이유' ;

CREATE INDEX idx_member_name ON member(member_name);

SELECT * FROM member WHERE member_name = '아이유' ;

CREATE VIEW member_view
AS
	SELECT * FROM member;

SELECT * FROM member_view;

SELECT * FROM member WHERE member_name = '나훈아';
SELECT * FROM product WHERE product_name = '삼각김밥';

DELIMITER //
CREATE PROCEDURE myProc() 
BEGIN
	SELECT * FROM member WHERE member_name = '나훈아';
	SELECT * FROM product WHERE product_name = '삼각김밥';
END //
DELIMITER ;

CALL myProc();