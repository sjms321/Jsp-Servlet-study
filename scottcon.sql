CREATE TABLE book (
    book_id     NUMBER(4),--NUMBER형 4글자까지 가질수있다.
    book_name   VARCHAR2(20),--VARCHAR는 CHAR과 다르게 가변형 변수이다 오라클사에서는 이걸 사용하기를 추천!
    book_loc    VARCHAR2(20)
);

SELECT * FROM book;
DROP TABLE book;

CREATE TABLE book (
book_id NUMBER(4) CONSTRAINT book_id_pk PRIMARY KEY, --중복없이 받는다는 뜻 피터팬 책이있으면 피터팬책이 또 db에 들어 올 시 fail됨 
book_name VARCHAR2(20),
book_loc VARCHAR2(20)
);

SELECT * FROM tab;

CREATE SEQUENCE book_seq;

INSERT INTO 
book(book_id, book_name, book_loc)
VALUES
(BOOK_SEQ.NEXTVAL, 'book5', '001
-00005');
COMMIT 

INSERT INTO book VALUES (
    book_seq.NEXTVAL,
    'book6',
    '001-00006'
);

UPDATE book SET book_loc = '001
-00006123' 
WHERE book_name = 'book6';

DELETE FROM book
WHERE book_name = 'book5';

-- 데이터 검색
SELECT * FROM book;
SELECT book_name, book_loc FROM book;
SELECT book_name AS 책이름, book_loc AS 책위치 FROM book;
-- 조건 - WHERE
SELECT * FROM book WHERE book_id > 3;
SELECT * FROM book WHERE book_id > 3 AND book_id <= 5;
-- 조건 - BETWEEN AND
SELECT * FROM book WHERE book_id BETWEEN 2 AND 4;
-- 조건 - LIKE
SELECT * FROM book WHERE book_id LIKE 3;
SELECT * FROM book WHERE book_loc LIKE '%3';
SELECT * FROM book WHERE book_name LIKE 'book%';
SELECT * FROM book WHERE book_name LIKE '%ok%';
-- 정렬
SELECT * FROM book ORDER BY book_id ASC;
SELECT * FROM book ORDER BY book_id DESC;
SELECT * FROM book ORDER BY book_name ASC;
SELECT * FROM book ORDER BY book_name DESC;