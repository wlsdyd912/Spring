<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>새글작성 페이지</h1>

<form action="insert" method="post">
	<input type="text" name = "title" placeholder="제목 입력" required="required"/>
	<br/>
	<textarea rows="5" cols="80" name="content" placeholder="내용 작성" required="required"></textarea>
	<br/>
	<input type="text" name="userId" placeholder="아이디 입력" required="required">
	<br/>
	<input type="submit" value="작성완료"/>
	
</form>
</body>
</html>