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
	<h2>공지사항 상세</h2>
	<table>
		<tr>
			<th>제목:</th>
			<td>${vo.title}</td>
		</tr>
		<tr>
			<th>작성자(id):</th>
			<td>${vo.uid }</td>
		</tr>
		<tr>
			<th>작성일:</th>
			<td>${vo.rdate }</td>
		</tr>
		<tr>
			<th>내용:</th>
			<td>${vo.content }</td>
		</tr>
	</table>
	<button onclick="document.deletefrm.submit();">삭제</button>
	<form name="deletefrm" action="delete.do" method="post">
		<input type="hidden" name="nno" value="${vo.nno}">
	</form>
	<!-- 클릭시 delete.do로 이동하여 해당 게시글의 state 칼럼 D로 변경 -->
	
	
	
	
</body>
</html>