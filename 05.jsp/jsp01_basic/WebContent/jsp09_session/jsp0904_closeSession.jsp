<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//session.invalidate();	//세션종료
	session.setMaxInactiveInterval(60);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>Session 종료하기</h1>
	Session이 종료가 되었습니다. <br />
	
	회원ID: <%=session.getAttribute("id") %> <br />
	회원명: <%=session.getAttribute("name") %> <br />
</body>
</html>