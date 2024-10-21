<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>게시글 목록</h1>
		<hr>
		<table class="table text-center">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.id}</td>
					<td>${board.title}</td>
					<td>${board.writer}</td>
					<td>${board.viewCnt}</td>
					<td>${board.regDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>