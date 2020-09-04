<%@page import="member.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
<%@include file="/common/head.jsp" %>
	<h3>회원 전체조회</h3>
	<ul Class="search">
		<li>메일수신여부</li>
		<li>성별</li>
		<li><button type="button">검색</button></li>
	</ul>
	<table id="members">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>성별</th>
			<th>직업</th>
			<th>이메일 동의 여부</th>
			<th>취미</th>
		</tr>
		<c:forEach items="${list }" var="member">
		<tr>
			<td><a href="memberSelect.jsp">${member.id }</a></td>
			<td>${ member.pw() }</td>
			<td>${ member.gender() }</td>
			<td>${ member.reason() }</td>
			<td>${ member.mailyn() }</td>
			<td>${ member.job() }</td>
			<td>${ member.hobby() }</td>
			<td>${ member.regdate() }</td>
		</tr>
		</c:forEach>>
	</table>
</body>
</html>