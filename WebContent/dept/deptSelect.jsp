<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>부서 상세 조회</h3>
<table>
	<tr>
		<td>부서번호</td>
		<td>${dept.department_id }</td>
	</tr>
	<tr>
		<td>부서명</td>
		<td>${dept.department_name }</td>
	</tr>
	<tr>
		<td>매니저</td>
		<td>${deptmanager_id }</td>
	</tr>
	<tr>
		<td>지역</td>
		<td>${ dept.location_id}</td>
	</tr>
</table>
</body>
</html>