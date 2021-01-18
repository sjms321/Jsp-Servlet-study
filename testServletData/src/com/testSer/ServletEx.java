package com.testSer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletEx extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId= getServletConfig().getInitParameter("adminId");
		String adminPw= getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out = response.getWriter();
		out.print("<p>adminId : "+adminId+"</p>");
		out.print("<p>adminPw : "+adminPw+"</p>");
		
		getServletContext().setAttribute("connectedIP1", "127.0.0.1");
		getServletContext().setAttribute("connectedIP2", "127.0.0.2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
