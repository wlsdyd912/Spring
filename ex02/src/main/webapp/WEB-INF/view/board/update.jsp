<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<h1>게시글 수정페이지</h1>

<ul>
	<li><a href="list">게시판 메인 페이지</a></li>
	<li><a href="" id="btnDel">삭제하기</a></li>
</ul>

<form action="update" method="post">
	<input type="number" name="bno" value="${board.bno}" readonly/>
	<br/>
	<input type="text" name="title" value="${board.title}" required/>
	<br/>
	<textarea rows="5" cols="80" name="content" required>${board.content}</textarea>
	<br/>
	<input type="text" name="userId" value="${board.userId}" readonly/>
	<br/>
	<fmt:formatDate value="${board.regDate}" 
		pattern="yyyy/MM/dd HH:mm:ss" var="regDate"/>
	<input type="text" value="${regDate}" readonly/>
	<br/>
	<input type="submit" value="수정완료" />
</form>

<script>
$(document).ready(function() {
	$('#btnDel').click(function(event) {
		event.preventDefault();
		var result = confirm('정말 삭제?');
		if (result == true){
		location = 'delete?bno=${board.bno}';
		}
	});
});
</script>
</body>
</html>