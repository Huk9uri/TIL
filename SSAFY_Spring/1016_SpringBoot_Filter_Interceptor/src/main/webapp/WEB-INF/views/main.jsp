<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>main.jsp</h2>
<a href ="/user/viewInfo"> 회원 정보 확인</a>

<c:if test="${empty user_id}">
	<a href = "/login"> 로그인</a>
</c:if>

<c:if test ="${not empty user_id}">
<h1>${user_id}님 반갑습니다????!</h1>
	<a href = "/logout"> 로그아웃</a>
</c:if>




</body>
</html>