<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<form action="joinOk.do" method="post">
		<table>
			<tr>
				<th align="right">아이디 : </th>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<th align="right">비밀번호 : </th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<th align="right">이름 : </th>
				<td><input type="text" name="name"></td>
			</tr>
		</table>
		<button>회원가입</button>
	</form>
</body>
</html>