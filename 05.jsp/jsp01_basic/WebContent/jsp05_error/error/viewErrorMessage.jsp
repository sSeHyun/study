<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1 style="color:red">에러메시지</h1>
	<b style="color:orange">요청처리과정에서 에러가 발생했습니다!</b> <br />
	<b style="color:orange">빠른 시간내에 문제를 해결하도록 하겠습니다.</b>
	
	<hr />
<!-- exception 기본객체를 사용하려면 해당 jsp파일이 error전용처리 페이지로 선언이 되어야한다.
	 error페이지로 선언하기 위해서는 page 디렉티브에 isErrorPage 속성을 true로 설정해야한다. 
	 -->
	에러타입 = <%= exception.getClass().getName() %> <br />
	에러메시지=<%= exception.getMessage() %>
</body>
</html>