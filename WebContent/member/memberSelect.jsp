<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>내 정보 조회</h3>
<div><span Class="label">아이디</span><span>arg</span></div>
<div><span Class="label">비밀번호</span><span>fd</span></div>
<div><span Class="label">직업</span><span>무직</span></div>
<div><span Class="label">가입동기</span><span>없음</span></div>
<div><span Class="label">성별</span><span>남</span></div>
<div><span Class="label">메일수신여부</span>yes<span></span></div> 
<button type="button" id="btnPage">목록으로</button>
<script>
	btnPage.addEventListener("click",goPage);
	function goPage(){
		//history.back();
		//history.go(-1);	//이전페이지 이동 넷 다 같음
		//location.href="memberAll.jsp";
		location.assing("memberAll.jsp");
}
</script>
</body>
</html>