<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>단순 파일 업로드 예제</h2>
	<form action="upload01.do" method="post" enctype="multipart/form-data">
		file : <input type="file" name="file01"><br>
		title : <input type="text" name="title"><br>
		content :<textarea name="content"></textarea><br>
		<button>저장</button>
	</form>
</body>
</html>