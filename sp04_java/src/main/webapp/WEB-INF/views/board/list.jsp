<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<div class="container-lg">
		<c:forEach items = "${list}" var="board">
			<div class ="row"><a href="/board/register?bno=${board.bno}">
			<div class="col">${board.bno }</div><div class="col">${board.writer }</div><div class="col">${board.title }</div>
			</a>
			</div>
			<div class="row">
				<div class="col">${board.content }</div>
			</div>
			<div class="card">
				<div class="header">
				댓글목록
				</div>
				<div class="body">
				<c:forEach items="${board.reply }" var="reply">
					<div>${reply.replyer} : ${reply.reply}</div>
				</c:forEach></div>
			</div>
		</c:forEach>
	  <!-- Content here -->
	</div>
	<a href= "/board/register">신규</a>
</body>
</html>