
<%@page import="java.util.concurrent.TimeUnit"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- session에 대해 할 건데 
	1.form태그로 하나의 logCon에게 줄 ID와 PW작성 login버튼
	2.logCon에서 정보를 받고 세션생성 loginOk 페이지로 이동
	3.logonOk에서 로그인 정보 출력 및 로그아웃 버튼 생성
	4.로그아웃 버튼은 누르면 logoutCon servlet으로 이동
	5.logoutCon에서 세션이 종료 되면서 로그인 화면으로 돌아감
	6. 이에 따라 처음 로그인 화면 앞에 세션이 존재하는지 안하는지 판단할 코드 작성
	-->
	<%
		/*	처음 로그인 화면 앞에 세션이 존재하는지 안하는지 판단할 코드 작성
		세션이 존재한다면 세션을 죽이고 
		세션이 존재하지않는다면 아래 폼을 사용하고
		*/
		if(session.getAttribute("memberID") != null){
			System.out.println("이미 로긴됨");
			response.sendRedirect("loginOk.jsp");
		}
	%>
	<form action="logCon" method="post"><!-- 개인 정보가 들어갈 예정이니 post방식을 사용한다. -->
		ID : <input type = "text" name ="mID"></br>
		PW : <input type = "password" name ="mPW"></br>
		<input type="submit" value="login"></br>
	</form>
</body>
</html>