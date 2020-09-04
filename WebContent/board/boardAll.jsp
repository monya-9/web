<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
	<h3>게시글 목록</h3>
<table>
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>내용 일부보기</th>
			<th>조회수</th>
			<th>첨부파일 유무</th>
		</tr>
		<tr>
			<td>냠냠</td>
			<td><a href="boardSelect.jsp">냠</a></td>
			<td>쿠쿠..</td>
			<td>20</td>
			<td>Y</td>
		</tr>
		<tr>
			<td>얍얍</td>
			<td><a href="boardSelect.jsp">얍</a></td>
			<td>후후..</td>
			<td>54</td>
			<td>Y</td>
		</tr>
		<tr>
			<td>욥욥</td>
			<td><a href="boardSelect.jsp">욥</a></td>
			<td>투투..</td>
			<td>68</td>
			<td>N</td>
		</tr>
	</table>
</body>
</html>