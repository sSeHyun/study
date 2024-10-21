<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>게시글 삭제 확인!</h1>
	<form action="deleteContentConfirm.jsp" method="post">
		<input type="text" name="id" value="${param.writer }" />
		게시글을 삭제하려면 작성자를 입력하세요! 	<br />
		작성자 : <input type="text" name="writer" placeholder="작성자를 입력하세요!" /> <br />
		<input type="submit" value="삭제확인"/>
	</form>

</body>
</html>