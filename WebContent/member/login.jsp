<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/common/head.jsp" %>
<%=request.getAttribute("errormsg") %>
	<form>
		<div>
			<label for="id">ID:</label>
			<input type="text" id="id" name="id" action="login"><br>
		</div>
		<div>
			<label for="pw">Password:</label>
			<input type="password"id="pw" name="pw"><br>
		</div>
		<button>로그인</button>
	</form>
</body>
</html>