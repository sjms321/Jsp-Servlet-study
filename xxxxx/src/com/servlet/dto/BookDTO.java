package com.servlet.dto;

public class BookDTO {//DTO는 책의 ID 이름 위치를 담고있는 단순한 객체
	//단순한 데이터 저장소 게터 세터만을 메소드로 구성한다.
	//따라서 데이터 베이스에서 가져올 데이터만 선언한다(?)
	int bookId;
	String bookName;
	String bookLoc;
	
	public BookDTO(int bookId,String bookName,String bookLoc) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookLoc = bookLoc;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookLoc() {
		return bookLoc;
	}
	//데이터를 수정할 일은 없으니 getter만 작성한다.
}
