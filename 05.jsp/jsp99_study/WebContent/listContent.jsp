<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="insertContent.jsp" method="post">
		<table board="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" placeholder="제목을 입력하세요.." /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer" placeholder="작성자명을 입력하세요.." /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" placeholder="내용을 입력하세요.." /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="게시글등록" /></td>
			</tr>
		
		</table>
	</form>
	
	<hr />
	<tabel board="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="content" items="${ }">
		</c:forEach>
		
		

	
	</tabel>

</body>
</html>