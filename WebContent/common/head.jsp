<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
<c:if test="${sessionScope.id != numll }">
	<li><a href="<%=application.getContextPath() %>/member/login.jsp">로그인</a>
</c:if>
	<li>${sessionScope.id }님<a href="/web/member/logout">로그아웃</a>
	<li><a href="<%=application.getContextPath() %>/member/memberUpdate">정보수정</a>
	<li><a href="<%=application.getContextPath() %>/dept/DeptInsertServ">부서등록폼</a>
	<li><a href="<%=application.getContextPath() %>/dept/deptSelectAll">부서전체조회</a>
	<li><a href="<%=application.getContextPath() %>/member/memberInsert.do">회원가입</a>
	<li><a href="<%=application.getContextPath() %>/member/memberSelectAll.do">회워원전체조회</a>
</ul>