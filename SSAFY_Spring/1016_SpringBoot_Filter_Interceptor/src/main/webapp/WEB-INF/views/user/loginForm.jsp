<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 화면</h1>

	<form action="/login" method="POST">
		ID : <input type="text" name="id"> 
		PW : <input type="password" name="pw">
		<button>로그인</button>
	</form>
</body>
</html>