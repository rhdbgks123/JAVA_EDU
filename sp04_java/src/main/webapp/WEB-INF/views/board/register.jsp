<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
<c:if test="${not empty board.bno}">게시글수정</c:if>
<c:if test="${empty board.bno}">게시글등록</c:if></h3>
	<form name="frm" action = "/board/register" method="post">
		<label>글번호</label><input name="bno" type="hidden" value="${board.bno}" readonly >
		<label>제목</label><input name="title" type="text" value="${board.title}" >
		<label>작성자</label><input name="writer" type="text" value="${board.writer}">
		<label>내용</label><textarea name="content">${board.content}</textarea>
		<button>등록</button>
		<c:if test="${not empty board.bno}">
			<button type="button" onclick="boardDelete()">삭제</button>
		</c:if>
	</form>
	<script>
		function boardDelete(){
			if(confirm('삭제할까요?')){
		        document.frm.action = "/board/delete";
		        document.frm.method = "post";
		        document.frm.submit();
			}
		}
	</script>
</body>
</html>