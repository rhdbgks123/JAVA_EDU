<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "/board/register" method="post">
		<label>제목</label><input name="title" type="text">
		<label>작성자</label><input name="writer" type="text">
		<label>내용</label><textarea name="content"></textarea>
		<button>등록</button>
	</form>
</body>
</html>