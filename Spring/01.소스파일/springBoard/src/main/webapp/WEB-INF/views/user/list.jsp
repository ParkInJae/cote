<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 목록</h1>
	<!-- 
		검색 기능 추가하기
		검색은 회원 아이디와 이름으로 가능
	 -->
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.uno}</td>
			<td><a href="view.do?uno=${vo.uno}">${vo.uid}</a></td>
			<td>${vo.rdate }</td>
		</tr>
		</c:forEach>
	</table>
	<!-- 페이징 영역 -->
	<c:if test="${paging.startPage > 1 }">
		<a href="list.do?nowPage=${paging.startPage-1}">&lt;</a>
	</c:if>
	
	<c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="cnt">
		<c:if test="${paging.nowPage eq cnt }">
			<b>${cnt}</b>
		</c:if>
		<c:if test="${paging.nowPage ne cnt }">
			<a href="list.do?nowPage=${cnt}">${cnt}</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${paging.endPage < paging.lastPage }">
		<a href="list.do?nowPage=${paging.endPage+1}">&gt;</a>
	</c:if>
	
	
</body>
</html>