package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();//�����ֱ����Ѱ��̴� response��
		
		String ID = request.getParameter("mID");//login.jsp������ ������ ������ request
		String PW = request.getParameter("mPW");
		
		Cookie[] cookies = request.getCookies();//������ ��Ű������ �����´�.
		Cookie cookie = null; // ��jsp���� ����� ��Ű��ü ����
		
		for(Cookie c : cookies) {
			//������ ��Ű���Ͽ� �ִ� ��Ű���� �̸��� ���� ����ϰ�
			//������ �α��� ������ ���δٸ� ������ ��Ű�� �� ��Ű�� �ִ´�.
			//�ٽø��� ��Ű�� ������ �ִٸ� ��Ȱ���ϰ� ���ٸ� ���� �����Ѵ�. 
			System.out.println("c.getName() : "+c.getName()+"c.getValue() : "+c.getValue());
			
			if(c.getName().equals("memberID")) {
				cookie = c;
			}			
		}
		if(cookie==null) {
			// �α����� ������ ���ٸ� ������ ��ü�� ��� ��������Ű�
			// ����ִٸ� ID�� ��Ű�� �ְ� "memberID"��� �̸����� ���� 
			System.out.println("cookie is null");
			cookie = new Cookie("memberID", ID);
			cookie = new Cookie("memberPW", PW);
			}
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
