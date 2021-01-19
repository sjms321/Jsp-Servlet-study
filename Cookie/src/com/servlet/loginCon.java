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
	
		PrintWriter out = response.getWriter();//보여주기위한것이니 response로
		
		String ID = request.getParameter("mID");//login.jsp파일의 정보를 가져옴 request
		String PW = request.getParameter("mPW");
		
		Cookie[] cookies = request.getCookies();//서버의 쿠키파일을 가져온다.
		Cookie cookie = null; // 이jsp에서 사용할 쿠키객체 생성
		
		for(Cookie c : cookies) {
			//서버의 쿠키파일에 있는 쿠키들의 이름과 값을 출력하고
			//기존의 로그인 흔적이 보인다면 생성한 쿠키에 그 쿠키를 넣는다.
			//다시말해 쿠키가 기존에 있다면 재활용하고 없다면 새로 생성한다. 
			System.out.println("c.getName() : "+c.getName()+"c.getValue() : "+c.getValue());
			
			if(c.getName().equals("memberID")) {
				cookie = c;
			}			
		}
		if(cookie==null) {
			// 로그인을 한적이 없다면 생성된 객체는 계속 비어있을거고
			// 비어있다면 ID를 쿠키에 넣고 "memberID"라는 이름으로 저장 
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
