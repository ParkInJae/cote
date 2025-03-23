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
	<h2>jstl을 배워보자</h2>
	<h3>jstl을 사용하여 영역별 속성(attribute) 선언하기</h3>
	
	<!-- pageContext.setAttribute("name","홍길동") -->
	<c:set var="name" value="홍길동" />
	
	${name}<br>
	
	<!-- request.setAttribute("id","honghong") -->
	<c:set var="id" value="honghong" scope="request" />
	
	${requestScope.id }<br>
	
	<!-- value 속성에 el을 사용하게 되면 연산의 결과 값을 대입할 수 있다. -->
	<c:set var="sum" value="${10+20}" />
	${sum}<br>
	
	<h3>attribute 제거하기</h3>
	<!-- 4개의 영역안에 있는 모든 sum attribute 제거 -->
	<c:remove var="sum"/>
	sum : ${sum}<br>
	<!-- scope 지정시 해당 영역에서 일치하는 attribute 제거 -->
	<c:remove var="id" scope="page" />
	id : ${id }<br>
	
	<h3>attribute 출력하는 태그</h3>
	<!-- 
	out 태그를 사용하면 html이 포함되어 있는 문자열의 경우 출력시 html을 무력화 시켜
	텍스트로만 출력할 수 있다. 이때 default 속성을 사용하면 출력값이 null일 시 대체
	텍스트를 지정할 수 있다.
	 -->
	<c:set var="html" value="${'<h1>hello</h1>'}" />
	el html : ${html}<br>
	jstl out html : <c:out value="${html}" default="none" /><br>
	
	<h3>if문 작성하기</h3>
	
	<c:if test="true">
	 true
	</c:if>
	
	<br>
	
	<c:if test="false">
	 false
	</c:if>
	
	
	<!-- 로그인 X -->
	<%-- <c:if test="${loginUser == null}"> --%>
	<c:if test="${empty loginUser}">
		<a href="<%=request.getContextPath()%>/login.do">로그인</a>
	</c:if>
	
	<!-- 로그인 O -->
	<%-- <c:if test="${loginUser != null }"> --%>
	<c:if test="${not empty loginUser }">
		<a href="<%=request.getContextPath()%>/mypage.do">마이페이지</a>
	</c:if>
	
	<h3>switch문 사용하기</h3>
	- jstl에서는 else if 문법은 없으므로 switch문을 사용하여 표현한다.<br>
	- choose 태그 안 when 의 test 속성이 최초 true인 태그 안의 실행문이 실행된다.<br>
	- when이 모두 false인 경우는  otherwise 태그 안의 실행문이 실행된다 <br>
	<!-- 
	switch(변수 or 식){
		case 값 : ...
	}
	 -->
	<c:choose>
		<c:when test="true">
			true1
		</c:when>
		<c:when test="true">
			true2
		</c:when>
	</c:choose>
	<br>
	
	<c:choose>
		<c:when test="${loginUser != null }">
			<a href="<%=request.getContextPath()%>/mypage.do">마이페이지</a>
		</c:when>
		<c:otherwise>
			<a href="<%=request.getContextPath()%>/login.do">로그인</a>
		</c:otherwise>
	</c:choose>
	
	<h3>for문 사용하기</h3>
	-forEach 태그 사용하여 반복문 실행<br>
	<c:forEach begin="1" end="10" step="2" var="count">
		반복${count}<br>
	</c:forEach>
	
	<br>
	<c:forEach items="${list}" var="vo">
		${vo.title}<br>
	</c:forEach>
	
</body>
</html>






