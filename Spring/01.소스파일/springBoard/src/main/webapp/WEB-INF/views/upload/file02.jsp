<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>다중 파일 업로드 예제</h2>
	<form action="upload02.do" method="post" enctype="multipart/form-data">
		file01 : <input type="file" name="file01"><br>
		file02 : <input type="file" name="file02"><br>
		file03 : <input type="file" name="file03"><br>
		<button>업로드</button>
	</form>
	<hr>
	<form action="upload03.do" method="post" enctype="multipart/form-data">
		file : <input type="file" name="multiFile" multiple><br>
		<!-- 
		 ?multiFile=ddd&multiFile=dfee&multiFile=3333
		 -->
		<button>업로드</button>
	</form>

</body>
</html>









