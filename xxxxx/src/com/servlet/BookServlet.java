package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.BookDAO;
import com.servlet.dto.BookDTO;

@WebServlet("/bs")
public class BookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		BookDAO bookDAO = new BookDAO();//만드는 순간 데이터 로딩 시작
		//드라이버 로딩하고 대기
		ArrayList<BookDTO> list = bookDAO.select();
		//이 리스드에는 ID 이름 위치가 담긴 하나의 객체를 리스트로 담는다.
		
		for(int i=0;i<list.size();i++) {
			BookDTO dto = list.get(i);
			int BookId = dto.getBookId();
			String BookName = dto.getBookName();
			String BookLoc = dto.getBookLoc();
			out.println("BookId : "+BookId+", BookName : "+BookName+", BookLoc : "+BookLoc+"<br>");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
