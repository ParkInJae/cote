<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String data1 = "페이지 데이터입니다.";

pageContext.setAttribute("data1",data1);//페이지 영역에 데이터 추가


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el 문법을 학습하자!</h2>
	
	<h3>el 리터럴</h3>
	문자열 : ${"데이터1"}<br>
	문자열 : ${'데이터2'}<br>
	논리값 : ${true }<br>
	null : ${null}<br><!-- null은 빈문자열로 출력 -->
	
	<h3>el 산술 연산자</h3>
	-el 안에서 연산식 사용시 연산의 결과만 출력<br>
	${10+1}<br>
	${10/2}<br>
	${10 div 2 }<br>
	${10 % 2 }<br>
	${10 mod 2 }<br>
	
	<h3>el 논리 연산자</h3>
	${true && false }<br>
	${true and false }<br>
	${true || false }<br>
	${true or false }<br>
	${!true }<br>
	${not true }<br>
	
	<h3>el 비교 연산자</h3>
	${10 == 11 }<br>
	${10 eq 11 }<br>
	${10 != 11 }<br>
	${10 ne 11 }<br>
	${10 < 11 }<br>
	${10 lt 11 }<br>
	${10 > 11 }<br>
	${10 gt 11 }<br>
	${10 <= 11 }<br>
	${10 le 11 }<br>
	${10 >= 11 }<br>
	${10 ge 11 }<br>
	
	<h3>el empty 연산자</h3>
	-객체가 null이거나 컬랙션 또는 배열의 크기가 0 일때 true<br>
	${empty null}<br>
	${not empty null}<br>
	
	<h3>el scope attribute 다루기</h3>
	- el은 문자열이지만 숫자 형식이라면 자동으로 형변환을 하여 연산을 한다.<br>
	${requestScope.data1}10<br>
	${data2 }<br>
	${vo.title }<br><!-- 객체의 필드 값은 객체키.필드명 으로 바로 출력할 수 있다. -->
	-------------------------------------<br>
	${details.title }<br>
	${details.writer }<br>
	${details.password }<br>
	${details.writeDate }<br>
	${details.content }<br>
</body>
</html>





