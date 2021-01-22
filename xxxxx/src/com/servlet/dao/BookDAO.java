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
//DB와 연결을 하는 객체 역할을 한다.
	/*
	웹서버는 DB와 연결하기 위해서 매번 커넥션 객체를 생성하는데, 이것을 해결하기 위해 나온것이 컨넥션 풀입니다.
	ConnectionPool 이란 connection 객체를 미리 만들어 놓고 그것을 가져다 쓰는것입니다. 
	또 다쓰고 난 후에는 반환해 놓는 것. 하지만 유저 한명이 접속해서 한번에 하나의 커넥션만 일으키지 않고
	게시판 하나만 봐도 목록볼때 한번, 글읽을때마다 한번, 글쓸때 한번 등등… 엄청나게 많은 커넥션이 일어나기에,
	커넥션풀은 커넥션을 또 만드는 오버헤드를 효율적으로 하기 위해 DB에 접속하는 객체를 전용으로 하나만 만들고, 
	모든 페이지에서 그 객체를 호출해다 사용한다면? 이렇게 커넥션을 하나만 가져오고 
	그 커넥션을 가져온 객체가 모든 DB와의 연결을 하는것이 바로 DAO 객체입니다
	즉, DAO(Data Access Object)는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담하도록 만든 
	오브젝트를 말한다.*/
//	String driver = "oracle.jdbc.driver.OracleDriver"; //오라클 id url등 정보를 가져온다,
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String id = "scott";
//	String pw = "tiger";//접속할 객체를 만들 것이기 떄문에 접속에필요한 정보를 적어놓는다.
	DataSource dataSource;
	
	public BookDAO() {
		try {
			//DB접속 로딩 작업을 해 놓는다.
			//왜why? 메인클래스에서 객체를 부른다느것은 이미 데이터베이스에 접속해서 어떠한 작업을 할 것이라는 말.
			//미리 로딩을 해 놓는 작업.
		//	Class.forName(driver);//로딩
			Context context =  new InitialContext();
			dataSource= (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//이제 생성자를 만들었으니 기능을 하는 메소드를 작성한다.
	public ArrayList<BookDTO> select() { //DTO그냥 list에 담아 주기만 한다! 
		
		//연결 객체 채우기
		//읽어들여서 출력한다.
		//읽을때 객체로 읽고 그 객체의 값을 get으로 끌어와서 출력 
		//사용한 자원을 닫아준다.
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null; //위에 설명과 마찬가지로 데이터 베이스 접속에 필요한 객체를 생성해 놓는다.
		
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
