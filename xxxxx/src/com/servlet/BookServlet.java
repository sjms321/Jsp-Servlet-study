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
		
		BookDAO bookDAO = new BookDAO();//����� ���� ������ �ε� ����
		//����̹� �ε��ϰ� ���
		ArrayList<BookDTO> list = bookDAO.select();
		//�� �����忡�� ID �̸� ��ġ�� ��� �ϳ��� ��ü�� ����Ʈ�� ��´�.
		
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
