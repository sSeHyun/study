<%@page import="com.lec.cookie.Cookies"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	response.addCookie(Cookies.createCookie("id", "sonny"));
	response.addCookie(Cookies.createCookie("name", "손흥민"));
	response.addCookie(Cookies.createCookie("path", "경로", "/jsp08_cookie", -1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<h1>JAVA로 COOKIE 생성하기</h1>
	JAVA클래스로 COOKIE를 생성했습니다.

</body>
</html>