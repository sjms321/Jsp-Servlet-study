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
		//String ID = getServletConfig().getInitParameter("adminID");//아래 생략가능
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
		//config의 경우 특정 jsp파일에서만 사용 가능 web.xml에서 지정가능.
		//application의 경우 모든 jsp파일애서 사용가능하다 
		//14학점-3학점=> 11학점 (27학점 중에 11학점이 전공을 들어야함 ) 19학점 수강가능  
		//2021-1 데베 캡디1 =>6 12학점 교양(핵심교양 3 일반교양 3 자유선택 12 중 6)
		//27-18 -> 9? 캡스톤 os 3학점 전공 끝  
		//데베3 캡스톤1,2 os(컴공 2학)3
		//남은 1년 해야할 것 
		//프로젝트, 캡스톤,  
		// 이번 겨울 방학 마지막 한달 반 목표
		//1. jsp(M) 2. 2020년 배운거 정리 및 업로드 3. spring
		//2020년에 내가 한일 
		//1놀았음(메) 2놀았음(이별) 3(수빈이랑 학기 시작)놀았음 인프 통네 정리 할 것 4놀았음
		//5인프 프로젝트 어디갔는지 소멸 ㅋㅋ 6 기말고사 
		//7 자바학원 알고리즘 ㅁㅁㅂㅈ 8 자바학원 학기시작 9 데마 빅데 통네 10 데마 프로젝트 스터디 하긴했음
		//11 산업혁명 프로젝트 배터리 뭐시 12 논문 작성 이번주안으로 끝내보자.. 
		
	%>
	<p>ID : <%=ID %></p>
	<p>PASS : <%=PASS %></p>
	<p>imgDir : <%=imgDir %></p>
	<p>TestServerIp : <%=TestServerIp %></p>
	<p>RealServerIp : <%=RealServerIp %></p>

</html>