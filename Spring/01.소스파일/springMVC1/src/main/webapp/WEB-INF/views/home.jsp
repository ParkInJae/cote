<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
</head>
<body>
<h1>
	Hello world!  hahahaha
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="<%=request.getContextPath()%>/sample.do">sample.do로 이동</a>
<br>

<a href="<%=request.getContextPath()%>/board/list.do">게시글 목록 페이지로 이동</a>
<!-- 
위 링크 클릭시 board/list.jsp 포워드
 -->
<a href="<%=request.getContextPath()%>/login.do">로그인 페이지로 이동</a>
<!-- 
위 링크 클릭시 user/login.jsp 포워드
 -->
<a href="<%=request.getContextPath()%>/join.do">회원 가입 페이지로 이동</a>

<!-- 
위 링크 클릭시 user/join.jsp 포워드
 -->
<br>
<a href="<%=request.getContextPath()%>/el.do">el 배우러 가기</a>
<br>
<a href="<%=request.getContextPath()%>/jstl.do">jstl 배우러 가기</a>


</body>
</html>















