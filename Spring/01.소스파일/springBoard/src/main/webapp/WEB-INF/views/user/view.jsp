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
	<h2>회원 상세정보</h2>
	<!-- 회원 목록페이지에서 id 클릭시 상세정보 페이지로 이동합니다.
	이때 클릭한 id 회원 정보를 전부 상세페이지에 출력합니다.
	관리자가 아니면 view.do는 접근할 수 없습니다.
	 -->
	 <table>
	 	<tr>
	 		<th>회원번호 :</th>
	 		<td>${vo.uno}</td>
	 	</tr>
	 	<tr>
	 		<th>아이디 :</th>
	 		<td>${vo.uid }</td>
	 	</tr>
	 	<tr>
	 		<th>비밀번호 :</th>
	 		<td>${vo.upassword }</td>
	 	</tr>
	 	<tr>
	 		<th>이름 :</th>
	 		<td>${vo.uname }</td>
	 	</tr>
	 	<tr>
	 		<th>연락처 :</th>
	 		<td>${vo.uphone }</td>
	 	</tr>
	 	<tr>
	 		<th>이메일 :</th>
	 		<td>${vo.uemail }</td>
	 	</tr>
	 	<tr>
	 		<th>가입일 :</th>
	 		<td>${vo.rdate }</td>
	 	</tr>
	 	<tr>
	 		<th>상태 :</th>
	 		<td>${vo.ustate }</td>
	 	</tr>
	 	<tr>
	 		<th>권한 :</th>
	 		<td>${vo.uauthorization }</td>
	 	</tr>
	 </table>
	 <button onclick="location.href='modify2.do?uno=${vo.uno}'">수정</button>
</body>
</html>




