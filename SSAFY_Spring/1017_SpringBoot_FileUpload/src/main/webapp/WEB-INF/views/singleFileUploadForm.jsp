<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 단일 파일 업로드</h1>
<form action = "/singleFileUpload" method = "post" enctype="multipart/form-data">
	<input type = "file" name = "file">
	<button>업로드</button>
</form>
</body>
</html>