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
	<h2>regist.jsp</h2>
	<c:if test="${not empty loginUser}"> ${loginUser}님 반갑습니다</c:if>
</body>
</html>