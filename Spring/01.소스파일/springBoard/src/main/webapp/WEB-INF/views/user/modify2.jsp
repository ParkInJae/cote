<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h2>회원정보 수정</h2>
	<form action="modify2.do" method="post">
		<table>
			<tr>
				<th>이름 :</th>
				<td><input type="text" name="uname" value="${vo.uname}"></td>
			</tr>
			<tr>
				<th>연락처 :</th>
				<td><input type="text" name="uphone" value="${vo.uphone }"></td>
			</tr>
			<tr>
				<th>이메일 :</th>
				<td><input type="text" name="uemail" value="${vo.uemail }"></td>
			</tr>
			<tr>
				<th>권한 :</th>
				<td>
					<input type="radio" name="uauthorization" value="A"
					<c:if test="${vo.uauthorization eq 'A' }">
					checked
					</c:if>
					>관리자
					<input type="radio" name="uauthorization" value="U"
					<c:if test="${vo.uauthorization eq 'U' }">
					checked
					</c:if>
					>일반
				</td>
			</tr>
		</table>
		<button>저장</button>
		<!-- 
		 상세페이지에서 수정버튼 클릭시 modify2.jsp가 포워드 됩니다.
		 이때 클릭한 회원의 상세데이터를 입력양식에 출력합니다.
		 -->
	</form>
</body>
</html>









