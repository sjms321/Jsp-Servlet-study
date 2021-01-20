CREATE TABLE book (
    book_id     NUMBER(4),--NUMBER�� 4���ڱ��� �������ִ�.
    book_name   VARCHAR2(20),--VARCHAR�� CHAR�� �ٸ��� ������ �����̴� ����Ŭ�翡���� �̰� ����ϱ⸦ ��õ!
    book_loc    VARCHAR2(20)
);

SELECT * FROM book;
DROP TABLE book;

CREATE TABLE book (
book_id NUMBER(4) CONSTRAINT book_id_pk PRIMARY KEY, --�ߺ����� �޴´ٴ� �� ������ å�������� ������å�� �� db�� ��� �� �� fail�� 
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

-- ������ �˻�
SELECT * FROM book;
SELECT book_name, book_loc FROM book;
SELECT book_name AS å�̸�, book_loc AS å��ġ FROM book;
-- ���� - WHERE
SELECT * FROM book WHERE book_id > 3;
SELECT * FROM book WHERE book_id > 3 AND book_id <= 5;
-- ���� - BETWEEN AND
SELECT * FROM book WHERE book_id BETWEEN 2 AND 4;
-- ���� - LIKE
SELECT * FROM book WHERE book_id LIKE 3;
SELECT * FROM book WHERE book_loc LIKE '%3';
SELECT * FROM book WHERE book_name LIKE 'book%';
SELECT * FROM book WHERE book_name LIKE '%ok%';
-- ����
SELECT * FROM book ORDER BY book_id ASC;
SELECT * FROM book ORDER BY book_id DESC;
SELECT * FROM book ORDER BY book_name ASC;
SELECT * FROM book ORDER BY book_name DESC;