<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 페이지</h2>

	<form action="join.do" method="post">
		아이디 :<input type="text" name="id"><br>
		비밀번호 :<input type="password" name="password"><br>
		이름 :<input type="text" name="name"><br>
		연락처 :<input type="text" name="phone"><br>
		주소 :<input type="text" name="address"><br>
		나이 : <input type="number" name="age"><br>
		<button>회원가입</button>
	</form>
	<!-- 1. 회원가입 버튼 클릭시 5개의 파라미터를 매핑되는 가상경로 메소드에서
	             콘솔에 전부 출력합니다. 
	     2. 출력후 페이지는 메인페이지로 이동합니다.
	-->
</body>
</html>




