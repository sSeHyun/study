<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>로그인</h1>
	
<!-- <form action="<%=request.getContextPath() %>/jsp0503_loginSuccess.jsp" method="post"> -->	
<!--	<form action="jsp0503_loginSuccess.jsp" method="post"> -->
	<form action="login" method="post">
		<input type="text" name="id" value="hong" /> <br />
		<input type="password" name="pw" value="12345" /> <br />
		<input type="text" name="name" value="홍길동" /> <br />
		<input type="submit" value="로그인"/>
	</form>
	<br />
	<!-- contextPath= http://localhost:8080/jsp05_servlet/ -->
	<!-- request(요청) :jsp0503_loginSuccess.jsp?id=hong&pw=12345&name=%ED%99%8D%EA%B8%B8%EB%8F%99"  -->
	<a href="http://localhost:8080/jsp05_servlet/jsp0503_loginSuccess.jsp?id=hong&pw=12345&name=%ED%99%8D%EA%B8%B8%EB%8F%99">로그인</a>
</body>
</html>