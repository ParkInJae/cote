<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String data = (String)request.getAttribute("data");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	sample.do 포워드 되는 웹 페이지 입니다!!
	<br>
	<%= data %>
</body>
</html>