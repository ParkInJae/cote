<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
	<h1>게시판 시스템 만들기</h1>
	<c:if test="${not empty loginUser }">
		<div>
			${loginUser.uid } 회원 님 환영합니다.
		</div>
		
		<a href="logout.do">로그아웃</a>
		<br>
		<!-- 로그인된 유저의 권한이 관리자인 경우 출력될 수 있도록 수정
		uauthorization 값이 A이면 관리자
		 -->
		<c:if test="${loginUser.uauthorization eq 'A' }">
			<a href="user/modify.do">회원 정보 수정</a><br>
			<a href="user/list.do">회원 목록 조회</a>
		</c:if>
		
		
		
	</c:if>
	
	<c:if test="${empty loginUser}">
		<a href="join.do">회원가입</a><br>
		<a href="login.do">로그인</a>
	</c:if>
	<br>
	
	<a href="board/list.do">공지사항 목록 이동</a>
	<br>
	
	<a href="ajax/example.do">ajax 연습하러 가기</a>
	
	<br>
	
	<a href="ajax/example02.do">ajax 복습하러 가기</a>
	<br>
	<a href="file/upload01.do">파일 업로드 예제1</a><br>
	<a href="file/upload02.do">파일 업로드 예제2</a><br>
	<br>
	<a href="login/notice/list.do">공지사항 목록 이동 (notice)</a>
</body>
</html>







