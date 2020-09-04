<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>게시글 조회</h3>
<div><span Class="label">작성자</span><span></span></div>
<div><span Class="label">제목</span><span></span></div>
<div><span Class="label">내용</span><span></span></div>
<div><span Class="label">작성일자</span><span></span></div>
<div><span Class="label">조회수</span><span></span></div>
<div><span Class="label">첨부파일</span><span></span></div>
<button type="button" onclick="goPage()">목록으로</button>
<script >
	function goPage(){
		//history.back();
		//history.go(-1);	//이전페이지 이동 넷 다 같음
		//location.href="memberAll.jsp";
		location.assing("memberAll.jsp");
	}
</script>
</body>
</html>