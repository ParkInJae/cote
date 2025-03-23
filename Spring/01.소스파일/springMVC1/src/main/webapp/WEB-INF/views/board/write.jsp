<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 등록 페이지 입니다.</h2>
	<form action="write.do" method="post">
		제목 : <input type="text" name="title"><br>
		작성자: <input type="text" name="writer"><br>
		비밀번호: <input type="password" name="password"><br>
		<!-- 작성일: <input type="date" name="writeDate"><br> -->
		아무거나 : <input type="text" name="other"><br>
		내용 : <textarea name="content" cols="30" rows="10"></textarea><br>
		<button>저장</button>
	</form>
</body>
</html>