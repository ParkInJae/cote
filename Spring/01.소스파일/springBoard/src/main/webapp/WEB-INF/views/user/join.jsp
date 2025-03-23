<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/javascript/jquery-3.7.1.min.js"></script>
<style>
	th{text-align:right;}
</style>
<script>
	function checkIdFn(){
		let id = $("#uid").val(); //입력 아이디 값
		
		$.ajax({
			url : "ajax/checkID.do",
			type : "get",
			data : {uid : id},
			success : function(data){
				
				if(data == "fail"){
					$("#checkID").text("사용할 수 없는 id 입니다.");	
				}else{
					$("#checkID").text("사용할 수 있는 id 입니다.");
				}
				
			},
			error : function(xhr){
				console.log(xhr);
			}
		});
	}

</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="join.do" method="post">
		<table>
			<tr>
				<th>아이디 : </th>
				<td>
					<input type="text" name="uid" id="uid">
					<button type="button" onclick="checkIdFn()">중복확인</button>
					<div id="checkID"></div>
					<!-- 
					중복확인 버튼 클릭시 DB에서 입력한 아이디와 일치하는 데이터가 존재하는지
					ajax를 통하여 확인합니다.
					만약 중복 id라면 checkID div에 '사용할 수 없는 id 입니다.' 출력
					중복  id가 아니라면 checkID div에  '사용할 수 있는 id 입니다.' 출력
					 -->
				</td>
			</tr>
			<tr>
				<th>비밀번호 : </th>
				<td><input type="password" name="upassword" id="upassword"></td>
			</tr>
			<tr>
				<th>비밀번호 확인 : </th>
				<td><input type="password" id="upasswordre"></td>
			</tr>
			<tr>
				<th>이름 : </th>
				<td><input type="text" name="uname" id="uname"></td>
			</tr>
			<tr>
				<th>연락처 : </th>
				<td><input type="text" name="uphone" id="uphone"></td>
			</tr>
			<tr>
				<th>이메일 : </th>
				<td><input type="text" name="uemail" id="uemail"></td>
			</tr>
		</table>
		<br>
		<button>회원가입</button>
	</form>
</body>
</html>








