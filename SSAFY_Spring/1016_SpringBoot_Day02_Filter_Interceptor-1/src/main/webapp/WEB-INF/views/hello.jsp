<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>HELLO JSP</h2>


	<c:if test="${empty loginUser}">
		<a href="/login">로그인하기</a>
	</c:if>

	<c:if test="${not empty loginUser}">
		<a href="/logout">로그아웃하기</a>
	</c:if>
</body>
</html>