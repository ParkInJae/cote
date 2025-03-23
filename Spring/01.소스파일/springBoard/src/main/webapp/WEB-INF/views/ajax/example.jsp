<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/javascript/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h2>ajax 복습하기!!</h2>
	
	<h3>ajax 활용하여 로그인 기능 구현하기</h3>
	- 아래 form에서 아이디와 비밀번호 입력 후 로그인 버튼 클릭시 로그인 처리를 합니다.<br>
	- 로그인에 성공시 'OOO(이름) 회원님 환영합니다' 메시지 창 출력
	- 로그인에 실패시 '일치하는 회원 정보가 없습니다' 메시지 창 출력
	<form style="border:1px solid black; width:400px;">
		<table>
			<tr>
				<th align="right">아이디 :</th>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<th align="right">비밀번호 :</th>
				<td><input type="password" name="upassword"></td>
			</tr>
		</table>
		<button type="button" onclick="loginFn()">로그인</button>
	</form>
	<script>
	function loginFn(){
		$.ajax({
			url : "login.do",
			data : $("form").serialize(),//uid=???&upassword=???
			type: "post",
			success : function(data){
				if(data != "fail"){
					//로그인 성공
					alert(data+" 회원님 환영합니다");
				}else{
					//로그인 실패
					alert("일치하는 회원 정보가 없습니다");
				}
			}
			
		});
	}
	</script>
	
	
	
	
	
	
	
</body>
</html>