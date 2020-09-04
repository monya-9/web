<%@page import="member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script >
/*
function inputCheck() {
	//아이디 패스워드 입력
	if(frm.id.value == "") {
		window.alert("id 입력");
		frm.id.focus();
		ret
	}
}
if(frm.job.value == "") {
	alert("job 선택");
	frm.job.focus();
	return;
}	
	radio, checkbox
	var gender =
		document.querySelectorAll("[name='gender']:checke").length;
	if(gender == 0) {
		alert("성별 적어도 하나는 선택");
		return ;
	}
	
	frm.submit();
	*/

</script>
</head>
<body>
<% MemberVo member = (MemberVo) session.getAttribute("login"); %>
<h3 Class="page_title">회원정보수정</h3>
	<form method="post" name="frm" id="frm" action="memberUpdate" >
		<div>
			<label for="id">ID:</label>
			<input type="text" id="id" name="id" value="<%=member.getId() %>" readonly="readonly"><br>
		</div>
		<div>
			<label for="pw">Password:</label>
			<input type="password"id="pw" name="pw" value="<%=member.getPw() %>"><br>
		</div>
		<div>
			<label for="gender">성별:</label>
			<input type="radio" id="male"name="gender" value="male" <%if("male".equals(member.getGender())) {out.print("checked='checked");} %>>
				<label for="male">남</label>
				<input type="radio" id="female" name="gender" value="female" <%if("female".equals(member.getGender())) {out.print("checked='checked");} %>>
				<label for="female">여</label><br>
		</div>
		<div>
			<label for="job">직업:</label> <select id="job" name="job">
				<option value="">선택</option>
				<option value="j1" <%if("j1".equals(member.getJob())) {out.print("selected='selected");} %>>학생</option>
				<option value="j2" <%if("j2".equals(member.getJob())) {out.print("selected='selected");} %>>주부</option>
				<option value="j3" <%if("j3".equals(member.getJob())) {out.print("selected='selected");} %>>군인</option>
				<option value="j4" <%if("j4".equals(member.getJob())) {out.print("selected='selected");} %>>직장인</option>
				<option value="j5" <%if("j5".equals(member.getJob())) {out.print("selected='selected");} %>>무직</option>
			</select><br>
		</div>
		<div>
			<label for="text">가입동기:</label><br>
			<textarea id="reason"name="reason"></textarea><br>
		</div>
		<div>
			<label for="vehicle1">메일수신여부:</label>
			<input type="checkbox" id="maileyn" name="maileyn" <%if("maileyn".equals(member.getMailyn())) {out.print("checked='checked");} %>><br>
		</div>
		<div>
			<label for="vehicle1">취미:</label>
			<input type="checkbox" id="hoby" name="hobby" value="read" <%if("read".equals(member.getHobby())) {out.print("checked='checked");} %>>독서
			<input type="checkbox" id="hoby" name="hobby" value="game" <%if("game".equals(member.getHobby())) {out.print("checked='checked");} %>>게임
			<input type="checkbox" id="hoby" name="hobby" value="ski" <%if("ski".equals(member.getHobby())) {out.print("checked='checked");} %>>스키<br>
		</div>
		<div>
			<button>등록</button>
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>