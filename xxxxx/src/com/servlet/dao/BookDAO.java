package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.servlet.dto.BookDTO;

public class BookDAO {
//DB�� ������ �ϴ� ��ü ������ �Ѵ�.
	/*
	�������� DB�� �����ϱ� ���ؼ� �Ź� Ŀ�ؼ� ��ü�� �����ϴµ�, �̰��� �ذ��ϱ� ���� ���°��� ���ؼ� Ǯ�Դϴ�.
	ConnectionPool �̶� connection ��ü�� �̸� ����� ���� �װ��� ������ ���°��Դϴ�. 
	�� �پ��� �� �Ŀ��� ��ȯ�� ���� ��. ������ ���� �Ѹ��� �����ؼ� �ѹ��� �ϳ��� Ŀ�ؼǸ� ����Ű�� �ʰ�
	�Խ��� �ϳ��� ���� ��Ϻ��� �ѹ�, ������������ �ѹ�, �۾��� �ѹ� �� ��û���� ���� Ŀ�ؼ��� �Ͼ�⿡,
	Ŀ�ؼ�Ǯ�� Ŀ�ؼ��� �� ����� ������带 ȿ�������� �ϱ� ���� DB�� �����ϴ� ��ü�� �������� �ϳ��� �����, 
	��� ���������� �� ��ü�� ȣ���ش� ����Ѵٸ�? �̷��� Ŀ�ؼ��� �ϳ��� �������� 
	�� Ŀ�ؼ��� ������ ��ü�� ��� DB���� ������ �ϴ°��� �ٷ� DAO ��ü�Դϴ�
	��, DAO(Data Access Object)�� DB�� ����� �����͸� ��ȭ�ϰų� �����ϴ� ����� �����ϵ��� ���� 
	������Ʈ�� ���Ѵ�.*/
//	String driver = "oracle.jdbc.driver.OracleDriver"; //����Ŭ id url�� ������ �����´�,
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String id = "scott";
//	String pw = "tiger";//������ ��ü�� ���� ���̱� ������ ���ӿ��ʿ��� ������ ������´�.
	DataSource dataSource;
	
	public BookDAO() {
		try {
			//DB���� �ε� �۾��� �� ���´�.
			//��why? ����Ŭ�������� ��ü�� �θ��ٴ����� �̹� �����ͺ��̽��� �����ؼ� ��� �۾��� �� ���̶�� ��.
			//�̸� �ε��� �� ���� �۾�.
		//	Class.forName(driver);//�ε�
			Context context =  new InitialContext();
			dataSource= (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//���� �����ڸ� ��������� ����� �ϴ� �޼ҵ带 �ۼ��Ѵ�.
	public ArrayList<BookDTO> select() { //DTO�׳� list�� ��� �ֱ⸸ �Ѵ�! 
		
		//���� ��ü ä���
		//�о�鿩�� ����Ѵ�.
		//������ ��ü�� �а� �� ��ü�� ���� get���� ����ͼ� ��� 
		//����� �ڿ��� �ݾ��ش�.
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null; //���� ����� ���������� ������ ���̽� ���ӿ� �ʿ��� ��ü�� ������ ���´�.
		
		try {
			
		//	con = DriverManager.getConnection(url,id,pw);
			con = dataSource.getConnection();
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				int bookId = res.getInt("book_id");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				BookDTO dao =new BookDTO(bookId, bookName, bookLoc);
				list.add(dao);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(res!=null)res.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
}
