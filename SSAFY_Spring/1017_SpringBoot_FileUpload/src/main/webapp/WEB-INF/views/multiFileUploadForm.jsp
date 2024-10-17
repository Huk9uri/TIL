<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 다중 파일 업로드 </h1>
<form action = "/multiFileUpload" method = "post" enctype="multipart/form-data">
	<input type = "file" name = "file" multiple="multiple">
	<button>업로드</button>
</form>
</body>
</html>