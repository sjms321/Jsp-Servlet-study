<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		String ID;
		String PASS;
		//String ID = getServletConfig().getInitParameter("adminID");//�Ʒ� ��������
		//String PASS = getServletConfig().getInitParameter("adminPass");
		String imgDir;
		String TestServerIp;
		String RealServerIp; 
	%>
	<%
		ID=config.getInitParameter("adminID");
		PASS=config.getInitParameter("adminPass");
		imgDir = application.getInitParameter("imgDir");
		TestServerIp = application.getInitParameter("TestServerIp");
		RealServerIp = application.getInitParameter("RealServerIp");
		//config�� ��� Ư�� jsp���Ͽ����� ��� ���� web.xml���� ��������.
		//application�� ��� ��� jsp���Ͼּ� ��밡���ϴ� 
		//14����-3����=> 11���� (27���� �߿� 11������ ������ ������ ) 19���� ��������  
		//2021-1 ���� ĸ��1 =>6 12���� ����(�ٽɱ��� 3 �Ϲݱ��� 3 �������� 12 �� 6)
		//27-18 -> 9? ĸ���� os 3���� ���� ��  
		//����3 ĸ����1,2 os(�İ� 2��)3
		//���� 1�� �ؾ��� �� 
		//������Ʈ, ĸ����,  
		// �̹� �ܿ� ���� ������ �Ѵ� �� ��ǥ
		//1. jsp(M) 2. 2020�� ���� ���� �� ���ε� 3. spring
		//2020�⿡ ���� ���� 
		//1�����(��) 2�����(�̺�) 3(�����̶� �б� ����)����� ���� ��� ���� �� �� 4�����
		//5���� ������Ʈ ��𰬴��� �Ҹ� ���� 6 �⸻��� 
		//7 �ڹ��п� �˰��� �������� 8 �ڹ��п� �б���� 9 ���� �� ��� 10 ���� ������Ʈ ���͵� �ϱ�����
		//11 ������� ������Ʈ ���͸� ���� 12 �� �ۼ� �̹��־����� ��������.. 
		
	%>
	<p>ID : <%=ID %></p>
	<p>PASS : <%=PASS %></p>
	<p>imgDir : <%=imgDir %></p>
	<p>TestServerIp : <%=TestServerIp %></p>
	<p>RealServerIp : <%=RealServerIp %></p>

</html>