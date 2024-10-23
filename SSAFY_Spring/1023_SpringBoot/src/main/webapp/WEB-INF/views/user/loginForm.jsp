<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LoginForm</h1>
	<form action="/login" method="POST">
		id : <input type="text" name="id" id="id" placeholder="아이디를 입력하세요.">
		pw : <input type="password" name="password" id="password"
			placeholder="비밀반호를 입력하세요.">
		<button>로그인</button>
	</form>
	
	<a href = "/regist"><button>회원가입</button></a>
</body>
</html>