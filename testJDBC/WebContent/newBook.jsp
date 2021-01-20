<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 등록할 책의 이름과 위치를 데이터를 받을 버튼 두개 생성후 submit  -->
 <form action="newBook" method="post">
 	book name:<input type="text" name ="book_name"></br>
 	book location : <input type="text" name="book_loc"></br>
 	<input type="submit" value="book register"> 
 </form>
</body>
</html>