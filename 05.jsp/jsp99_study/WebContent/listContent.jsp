<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

</body>
</html>