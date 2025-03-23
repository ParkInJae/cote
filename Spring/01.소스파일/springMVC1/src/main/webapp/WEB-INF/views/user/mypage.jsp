<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>마이 페이지 입니다.</h2>
	<!-- 컨트롤러에서 넘긴 UserVO 정보를 전부 한줄씩 출력하세요.(el 사용합니다) -->
	id : ${user.id}<br>
	name : ${user.name}<br>
	phone : ${user.phone}<br>
	address : ${user.address}<br>
	password : ${user.password}<br>
	
</body>
</html>