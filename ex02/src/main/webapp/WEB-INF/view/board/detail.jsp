<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02</title>
</head>
<body>

<h1>게시글 상세보기 페이지</h1>

<ul>
	<li><a href="list">게시판 메인 페이지</a></li>
	<li><a href="update?bno=${board.bno}">수정하기</a></li>
</ul>

<form action="">
	<input type="number" value="${board.bno}" readonly/>
	<br/>
	<input type="text" value="${board.title}" readonly/>
	<br/>
	<textarea rows="5" cols="80" readonly>${board.content}</textarea>
	<br/>
	<input type="text" value="${board.userId}" readonly/>
	<br/>
	<fmt:formatDate value="${board.regDate}" 
		pattern="yyyy/MM/dd HH:mm:ss" var="regDate"/>
	<input type="text" value="${regDate}" readonly/>
	
</form>

</body>
</html>