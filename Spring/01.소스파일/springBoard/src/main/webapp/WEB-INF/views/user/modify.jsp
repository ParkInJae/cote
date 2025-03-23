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
	<h2>회원 정보 수정하기</h2>
	<form action="modify.do" method="post">
		<table>
			<tr>
				<th>수정할 회원 id : </th>
				<td><input type="text" name="uid" id="uid"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">수정 정보 입력</td>
			</tr>
			<tr>
				<th>이름 : </th>
				<td><input type="text" name="uname" id="uname"></td>
			</tr>
			<tr>
				<th>연락처 : </th>
				<td><input type="text" name="uphone" id="uphone"></td>
			</tr>
			<tr>
				<th>이메일 : </th>
				<td><input type="text" name="uemail" id="uemail"></td>
			</tr>
		</table>
		<button>저장</button>
	</form>
	<!-- 
		메인페이지에서 회원정보 수정 링크 클릭시 modify.jsp가 포워드 됩니다.
		
		modify.jsp에서 회원 정보 입력후 저장 버튼 클릭시
		입력한 아이디와 일치하는 부가정보들을 DB에서 수정합니다.
		
		이때 입력한 아이디와 일치하는 정보가 있어 수정 완료시에는 메인페이지로 이동합니다.
		입력한 아이디와 일치하는 정보가 없어 수정 미완료시 다시 회원정보 수정 페이지로 이동합니다.
	 -->
</body>
</html>








