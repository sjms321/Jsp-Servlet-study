<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  loginOk.jsp�� �� ��:
	cookie���� �о���δ�. cookie�ȿ� ������ �̿��Ͽ� �α���id�� ����Ѵ�.  -->
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			out.print("c.getName() : "+c.getName()+"c.getValue() : "+c.getValue());
			out.print("\t");
		}
	%>
</body>
</html>