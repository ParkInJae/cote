<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th{text-align:right;}
</style>
</head>
<body>
	<h1>로그인</h1>
	<form action="login.do" method="post">
		<table>
			<tr>
				<th>아이디 :</th>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<th>비밀번호 :</th>
				<td><input type="password" name="upassword"></td>
			</tr>
		</table>
		<button>로그인</button>
	</form>
</body>
</html>