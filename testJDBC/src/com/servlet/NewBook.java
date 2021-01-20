package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/newBook")
public class NewBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8"); //한글설정?
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//실무에서는 데이터 베이스의IP의PORT번호가 들어간다.
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null; //통신과 연결을 담당할 객체 생성
		Statement stmt = null;
		
		try {//서버와 진행하기 떄문에 오류가 많이 날수 있음으로 반드시 예외문을 작성해야함
			Class.forName(driver);//oracleDirver로딩
			
			con = DriverManager.getConnection(url, id, pw); //데이터베이스 위치 계정ID 비밀번호 3개의 정보를 전해주며 connection됨
			stmt = con.createStatement();//통신객체 생성
			String sql = "INSERT INTO book(book_id, book_name, book_loc)";//query문 작성
					sql += " VALUES (BOOK_SEQ.NEXTVAL, '" + bookName + "', '" + bookLoc + "')";
			int result = stmt.executeUpdate(sql);//통신객체stmt를 이용하여 query문을 전송한다.
			
			if(result == 1) {//query문 전송 성공
				out.print("INSERT success!!");
				//성공시 등록 성공하고 리스트를 보거나 새로운 등록을 선택 할 수있는 창 만들기
				response.sendRedirect("Select.jsp");
			} else {//실패
				out.print("INSERT fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//반드시 해줘야함 자원을 사용하면 반드시 해제해줘야한다.
						try { 
				if(stmt != null) stmt.close();//생성의 역순으로 stmt먼저 해제(자원을 반환하는 행위)
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
