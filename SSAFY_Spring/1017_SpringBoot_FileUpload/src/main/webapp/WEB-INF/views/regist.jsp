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
	<c:if test="${not empty fileNames}">
		<c:forEach items="${fileNames}" var="fileName">
			<img src="/img/${fileName}">
			<a href = "/download?fileName=${fileName}">다운로드</a>
		</c:forEach>
	</c:if>
	<c:if test="${empty fileNames}">
		<a href="/img/${fileName}">${fileName}</a>
		<img src="/img/${fileName}">
		<a href = "/download?fileName=${fileName}">다운로드</a>
	</c:if>
</body>
</html>