<%@page import="java.util.concurrent.Exchanger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
에러발생. 관리자에게 문의바람.
에러내용: <%=exception.getMessage() %>
에러타입: <%=exception.getClass().getName() %>
</body>
</html>