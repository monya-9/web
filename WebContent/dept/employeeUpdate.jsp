<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
	label { display: inline-block; width : 100px}
</style>
</head>
<body>
   <h1>사원수정</h1>
   <form action="empInsert">  
    <div><label>employeeId</label> <input name="employeeId" value="${emp.___ }"></div>
    <div><label>firstName</label> <input name="firstName"></div>
    <div><label>lastName</label> <input name="lastName"></div>
    <div><label>email</label> <input name="email"></div>
    <div><label>hireDate</label> <input name="hireDate"></div>
    <div><label>department_id</label>
    <input type="radio">개발
    <c:forEach items="${deptdatas}" var="departments">
    <input type="radio" name="department_id" value="${departments.department_id }">${departments.department_name }
    </c:forEach></div>
    <div><label>jobId</label> <select name="job_id">
    		<option value="">선택
    		<c:forEach items="${jobdatas }" var="jobs">
			<option value="${jobs.job_id }">${jobs.job_title }
    		</c:forEach>
    	  </select></div>
    <div><label>manager_id</label> <select name="manager_id">
    			<option value="">선택
				<c:forEach items="${manadatas }" var="employees">
				<option value="${employees.manager_id }">${employees.last_name }
				</c:forEach>
    	       </select></div>
    <button>등록</button>
    </form>
</body>
</html>