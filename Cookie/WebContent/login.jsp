<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- �α��� ȭ�鿡�� ID�� PW�Է�(form����)
		loginOk.jsp�� �̵� 
		��Ű�迭�� ��Ű�� ������ �����ϰ� ����ϴ� jsp�̴�
		servlet�� ����: login.jsp�� ID�� PW������ �ް� ��Ű������ ���� �˻��� ��Ű�� ���� ���ϰ�
		��Ű�� ��ȿ�ð��� ���� �� loginOk.jsp�� responese.sendRedirect��   -->
		
	<!-- �켱 ��Ű�� �޾Ƽ� ��Ű�� �α��� ������ �ִٸ� loginOk.jsp�� ������ ���ٸ� �α��� ������
	�о� ���̴� form������ ������ �����. 
	��Ű�� ����� -> form�Է�
	��Ű�� �����Ѵ� -> �α��� �������ִ��� Ȯ�� -> �ִٸ� logonOk.jsp�� ������ form-->	
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			//�ֳ����� ã�ƺ���
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