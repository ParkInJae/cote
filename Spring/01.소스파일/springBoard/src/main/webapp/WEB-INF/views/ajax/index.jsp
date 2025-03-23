<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="<%=request.getContextPath()%>/javascript/jquery-3.7.1.min.js"></script>

<script>
	function callFn01() {
		$.ajax({
			url : "text.do",
			success : function(data) {
				console.log(data);
				$("#result1").text(data);
			},
			error : function(xml, error) {
				console.log(error);
			}
		});
	}
</script>
</head>
<body>
	<h2>ajax 연습하기!</h2>
	<button onclick="callFn01()">ajax 호출1</button>
	<div id="result1"></div>
	<hr>
	<input type="text" id="param1">
	<button onclick="callFn02()">ajax 호출2</button>
	<script>
		function callFn02() {
			let value = $("#param1").val();

			$.ajax({
				url : "param.do",
				data : {
					param1 : value
				},
				success : function(data) {
					console.log(data);
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		}
	</script>
	<div id="result2"></div>
	<hr>
	<input type="text" id="id">
	<button onclick="cntFreeFn()">조회</button>
	<div id="result3"></div>
	<script>
		function cntFreeFn() {
			let id = $("#id").val();

			$.ajax({
				url : "cntFreeByUid.do",
				type : "get",
				data : {
					uid : id
				},
				success : function(data) {
					$("#result3").text(
							id + "가 작성한 자유게시글 갯수는 " + data + "건 입니다.");
				}
			});
		}
	</script>
	<!-- 
	입력한 아이디로 작성한 자유게시판 게시글 갯수를
	ajax로 조회버튼 클릭시 result3 div에 출력합니다.
	자유게시판은 free_board 테이블 입니다.
	
	Mapper는 NoticeeMapper.xml 사용하시면 됩니다.
	 -->
	<hr>
	<button onclick="printUserFn()">현재 로그인 회원 정보 불러오기</button>
	<div id="result4"></div>
	<script>
		function printUserFn() {
			$.ajax({
				url : "findLoginUser.do",
				type : "get",
				success : function(data) {
					console.log(data.uno);
					console.log(data.uid);
					console.log(data.uname);
				},
				error : function() {
					console.log("error");
				}
			});
		}
	</script>
	<hr>
	<button onclick="callListFn()">ajax를 통하여 배열 요청</button>
	<div id="result5"></div>
	<script>
		function callListFn() {
			$.ajax({
				url : "list.do",
				success : function(data) {
					console.log(data);
					for (let i = 0; i < data.length; i++) {
						console.log(data[i].uname);
					}
				}
			});
		}
	</script>
	<hr>
	<button onclick="otherTypeCallFn()">두 타입 데이터 요청</button>
	<script>
		function otherTypeCallFn() {
			$.ajax({
				url : "otherTypeCall.do",
				success : function(data) {
					console.log(data);
					console.log(data.paging.startPage); //paging 객체의 startPage 필드값 출력

					//list안의 uname 필드값 반복문을 사용하여 console에 출력하세요.
					for (let i = 0; i < data.list.length; i++) {
						console.log(data.list[i].uname);
					}
				}
			});
		}
	</script>

	<hr>
	<button onclick="callNoticeListFn()">공지사항 게시글 목록 조회</button>
	<table border="1" id="noticeList">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자(id)</th>
			<th>작성일</th>
		</tr>
		<!-- 내용출력 -->
	</table>
	<script>
		function callNoticeListFn() {
			$.ajax({
				url : "noticeList.do",
				success : function(data) {
					let html = "";
					for (let i = 0; i < data.length; i++) {
						html += "<tr>";
						html += "<td>" + data[i].nno + "</td>";
						html += "<td><a href='javascript:noticeViewFn("
								+ data[i].nno + ")'>" + data[i].title
								+ "</a></td>";
						html += "<td>" + data[i].uid + "</td>";
						html += "<td>" + data[i].rdate + "</td>";
						html += "</tr>";
					}

					$("#noticeList").append(html);
				}
			});
		}
	</script>
	<hr>
	<div>
		<table id="noticeView">
			<tr>
				<th align="right">글번호 :</th>
				<td></td>
			</tr>
			<tr>
				<th align="right">제목 :</th>
				<td></td>
			</tr>
			<tr>
				<th align="right">작성자(id) :</th>
				<td></td>
			</tr>
			<tr>
				<th align="right">상태 :</th>
				<td></td>
			</tr>
			<tr>
				<th align="right">내용 :</th>
				<td></td>
			</tr>
		</table>
		<script>
			function noticeViewFn(nno) {
				$.ajax({
					url : "noticeView.do",
					data : {
						nno : nno
					},
					success : function(data) {
						$("#noticeView td:eq(0)").text(data.nno);
						$("#noticeView td:eq(1)").text(data.title);
						$("#noticeView td:eq(2)").text(data.uid);
						$("#noticeView td:eq(3)").text(data.state);
						$("#noticeView td:eq(4)").text(data.content);
					}
				});
			}
		</script>
	</div>
	<!-- 
	 공지사항 목록 그리드에서 각 제목을 클릭하면 클릭한 제목과 일치하는 상세데이터를
	 하단의 noticeView 테이블의 각각 셀에 맞춰 ajax 통신으로 출력합니다.
	 
	 *힌트 : 링크 클릭시 클릭한 게시글의 글번호를 매개값으로 전달하여 컨트롤러까지
	 	      보내 상세 조회 데이터로 사용합니다.
	 
	  -->
</body>
</html>









