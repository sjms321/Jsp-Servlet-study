
<%@page import="org.apache.jasper.el.JspMethodExpression"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!int a = 10;
	String str = "jsp";
	ArrayList<String> list = new ArrayList<String>();

	public void jspMethod() {
		System.out.println("dd");
	}%>
	<%@ include file="Header.jsp"%>
	<%
	if (a == 10) {
	%>
	<p>hey</p>
	<%
	} else {
	%>
	<p>bye</p>
	<%
	}
	%>
	<p>
		num is
		<%=a%></p>
	<%
	jspMethod();
	%>
	<%@ include file="Footer.jsp"%>
</body>
</html>