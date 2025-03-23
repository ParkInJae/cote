<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>글등록</h2>
	<form action="writeOk.do" method="post">
		<table>
			<tr>
				<th>제목 :</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용 :</th>
				<td><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
		</table>
		<button>저장</button>
	</form>
	<!-- 저장 버튼 클릭시 실제 notice_board 테이블에 insert 되도록 기능을 구현하세요.
		저장된 후 화면은 현재 등록된 게시글의 상세페이지로 이동합니다.
		
		*상세페이지도 구현하세요
		
		상세페이지 링크 :/board/view.do
		상세페이지 포워드 화면 경로 : /views/notice/view.jsp
		출력되어야하는 정보 : 제목, 내용, 작성자(id), 조회수, 상태 
	 -->
</body>
</html>






