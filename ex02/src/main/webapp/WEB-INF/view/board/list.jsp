<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<h1>게시판 메인 페이지</h1>

<ul>
	<!--  새글작성의 요청 주소: board/insert 
		JSP 파일이 있는 폴더 위치를 기준으로 요청 주소가 생성됨-->
	<li><a href="insert">새글작성</a></li>
	<li><a>로그인</a></li>
	<li><a>회원가입</a></li>
</ul>

<table>
	<thead>
	 	<tr>
	 		<th>번호</th>
	 		<th>제목</th>
	 		<th>작성자</th>
	 		<th>작성시간</th>
	 		<th>조횟수</th>
	 	</tr>
	</thead>
	<tbody>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.bno}</td>
				<td><a href="detail?bno=${board.bno}">${board.title}</a> [${board.replyCnt}]</td>
				<td>${board.userId}</td>
				<fmt:formatDate value="${board.regDate}" pattern="yyyy/MM/dd HH:mm" var="regDate"/>
				<td>${regDate}</td>
				<td>${board.readCnt}</td>
			</tr>
		</c:forEach>	
	
	</tbody>
</table>

<script>
$(document).ready(function() {
	if ('${updateResult}' == 'success') {
		alert('게시글 수정 성공');
	}
	
	if ('${deleteResult}' == 'success') {
		alert('게시글 ' + ${deleteBno} + '번 삭제 성공');
	}
});
</script>
</body>
</html>