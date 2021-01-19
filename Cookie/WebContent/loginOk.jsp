<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  loginOk.jsp가 할 일:
	cookie값을 읽어들인다. cookie안에 정보를 이용하여 로그인id를 출렷한다.  -->
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			out.print("c.getName() : "+c.getName()+"c.getValue() : "+c.getValue());
			out.print("\t");
		}
	%>
</body>
</html>