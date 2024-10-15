<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri ="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
<h2>Hello.jsp 입니다.</h2>
<h3>${msg }</h3>

<c:if test ="${empty loginUser}">
	<a href = "login">로그인하기</a>
</c:if>

<c:if test ="${not empty loginUser }">
	<span>${loginUser }님 반갑습니다</span>
	<a href = "logout">로그아웃하기</a>
</c:if>
</body>
</html>