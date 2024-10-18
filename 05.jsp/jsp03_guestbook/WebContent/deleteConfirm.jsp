<%@page import="com.lec.service.DeleteMessageService"%>
<%@page import="com.lec.dao.MessageDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	DeleteMessageService instance=DeleteMessageService.getInstance();
	int id=Integer.parseInt(request.getParameter("id"));
	String pw=request.getParameter("password");
	instance.deleteMessage(id,pw);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>삭제성공!</h1>
	${param.id } <br />
	${param.password }
</body>
</html>