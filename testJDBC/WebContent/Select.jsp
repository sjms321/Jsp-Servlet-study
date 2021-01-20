<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<p>"등록이 완료 되었습니다"</p>
<form action="newBook" method="post">
			book name : <input type="text" name="book_name"></br>
			book location : <input type="text" name="book_loc"></br>
			<input type="submit" value="new book register">
		</form>
		
<form action="bs" method="post">
			<input type="submit" value="See Book list">
		</form>
</body>
</html>