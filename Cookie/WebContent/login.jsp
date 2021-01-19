<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 로그인 화면에서 ID와 PW입력(form형식)
		loginOk.jsp로 이동 
		쿠키배열에 쿠키의 정보를 저장하고 출력하는 jsp이다
		servlet의 역할: login.jsp의 ID와 PW정보를 받고 쿠키파일의 유무 검사후 쿠키를 새로 더하고
		쿠키의 유효시간을 설정 후 loginOk.jsp로 responese.sendRedirect함   -->
		
	<!-- 우선 쿠키를 받아서 쿠키에 로그인 정보가 있다면 loginOk.jsp로 보내고 없다면 로그인 정보를
	읽어 들이는 form형식이 나오게 만든다. 
	쿠키가 비었다 -> form입력
	쿠키가 존재한다 -> 로그인 정보가있는지 확인 -> 있다면 logonOk.jsp로 없으면 form-->	
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			//있나없나 찾아보기
			for(Cookie c: cookies){
				if(c.getName().equals("memberID")){
					response.sendRedirect("loginOk.jsp");
				}
			}
		}
	%>
	
	
	<form action="loginCon" method="post">
		ID : <input type="text" name="mID"></br>
		PW : <input type="password" name="mPW"></br>
		<input type = "submit"  value = "login">
	</form>
</body>
</html>