
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
	<!-- session�� ���� �� �ǵ� 
	1.form�±׷� �ϳ��� logCon���� �� ID�� PW�ۼ� login��ư
	2.logCon���� ������ �ް� ���ǻ��� loginOk �������� �̵�
	3.logonOk���� �α��� ���� ��� �� �α׾ƿ� ��ư ����
	4.�α׾ƿ� ��ư�� ������ logoutCon servlet���� �̵�
	5.logoutCon���� ������ ���� �Ǹ鼭 �α��� ȭ������ ���ư�
	6. �̿� ���� ó�� �α��� ȭ�� �տ� ������ �����ϴ��� ���ϴ��� �Ǵ��� �ڵ� �ۼ�
	-->
	<%
		/*	ó�� �α��� ȭ�� �տ� ������ �����ϴ��� ���ϴ��� �Ǵ��� �ڵ� �ۼ�
		������ �����Ѵٸ� ������ ���̰� 
		������ ���������ʴ´ٸ� �Ʒ� ���� ����ϰ�
		*/
		if(session.getAttribute("memberID") != null){
			System.out.println("�̹� �α��");
			response.sendRedirect("loginOk.jsp");
		}
	%>
	<form action="logCon" method="post"><!-- ���� ������ �� �����̴� post����� ����Ѵ�. -->
		ID : <input type = "text" name ="mID"></br>
		PW : <input type = "password" name ="mPW"></br>
		<input type="submit" value="login"></br>
	</form>
</body>
</html>