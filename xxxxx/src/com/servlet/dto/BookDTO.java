package com.servlet.dto;

public class BookDTO {//DTO�� å�� ID �̸� ��ġ�� ����ִ� �ܼ��� ��ü
	//�ܼ��� ������ ����� ���� ���͸��� �޼ҵ�� �����Ѵ�.
	//���� ������ ���̽����� ������ �����͸� �����Ѵ�(?)
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
	//�����͸� ������ ���� ������ getter�� �ۼ��Ѵ�.
}
