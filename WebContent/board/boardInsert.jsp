<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>게시글 작성</h3>
<label for="title">제목</label>
<input type="text" id="title" name="title" placeholder="제목을 입력해 주세요."><br>
<label for="writer">작성자</label>
<input type="text" id="writer" name="writer" placeholder="작성자를 입력해 주세요."><br>
<label for="content">내용</label><br>
<textarea cols="40" rows="40" id="content" name="content" placeholder="내용을 입력해 주세요." ></textarea><br>
<button type="submit" class="btnsubmit">등록하기</button>

</body>
</html>