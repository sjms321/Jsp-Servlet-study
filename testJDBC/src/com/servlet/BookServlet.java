package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bs")
public class BookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");//한글 설정
		PrintWriter out = response.getWriter();//
		
		String driver = "oracle.jdbc.driver.OracleDriver"; //오라클 id url등 정보를 가져온다,
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null; //연결, 통신, 데이터 읽어들이기 위한 객체를 생성한다.
		Statement stmt = null;
		ResultSet res = null;/*- 결과값을 저장할 수 있다.
		 						 저장된 값을 한 행 단위로 불러올 수 있다. 
		 						 한 행에서 값을 가져올 때는 타입을 지정해 불러올 수 있다.
		 						*/
		
		try {
			Class.forName(driver);//oracleDrive로딩
			
			con = DriverManager.getConnection(url, id, pw);// 데이터 베이스 위치 계정ID 비밀번호 정보를전달.
			stmt = con.createStatement();//통신객체생성
			String sql = "SELECT * FROM book";//BOOK테이블에 모든 정보를 읽어들인다.
			res = stmt.executeQuery(sql);//조회 결과값을 res에 저장한다.
			
			while (res.next()) {//res를 한행씩 읽어들인다. 다음 행이 있다면 true 없으면 false반환
				int bookId = res.getInt("book_id"); //열의 정보를 가져온다
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				out.print("bookId : " + bookId + ", ");
				out.print("bookName : " + bookName + ", ");
				out.print("bookLoc : " + bookLoc + "</br>");
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
