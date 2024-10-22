<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<h1>로그인 성공</h1>
	로그인 아이디 : ${param.id } <br />
	로그인 비밀번호 : ${param.pw } <br />
	로그인 이름 : ${param.name } <br />
</body>
</html>