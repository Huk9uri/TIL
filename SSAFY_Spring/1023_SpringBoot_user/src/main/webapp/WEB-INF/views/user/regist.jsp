<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원가입 </h1>
<form action="/regist" method="POST">
	아이디 : <input type = "text" name = "id" id = "id">
	비밀번호 : <input type="password" name = "password" id = "password">
	이름 : <input type ="text" name = "name" id = "name">
	직책 : <select name="grade" id="grade">
					<option value="교수">교수</option>
					<option value="반장">반장</option>
					<option value="CA">CA</option>
					<option value="일반">일반</option>
				</select>
	캠퍼스 : <select name= "region" id="region">
					<option value="서울">서울</option>
					<option value="광주">광주</option>
					<option value="대전">대전</option>
					<option value="구미">구미</option>
					<option value="부울경">부울경</option>
				</select>
	<button>회원가입</button>
</form>


</body>
</html>