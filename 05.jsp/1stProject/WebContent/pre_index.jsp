<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/b33442fb56.js" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String customer_id = (String)session.getAttribute("customer_id"); 
		String customer_pw = (String)session.getAttribute("customer_pw"); 	
	%>
	
	<center>
	
	<%if(customer_id != null){ %>
	<%=customer_id %> 님 안녕하세요.
	<br />
	<a class="btn btn-success" href="customerLogout.cs">로그아웃</a>
	<a class="btn btn-success" href="customerList.cs">회원목록</a>
	<a class="btn btn-success" href="roomList.ht">객실목록</a>
	<%}%>
	
	<%if(customer_id == null){%>
	<a class="btn btn-success" href="customerLoginForm.cs" >로그인</a>
	<a class="btn btn-success" href="customerCreateForm.cs">회원가입</a>
	<%}%>
	
	</center>

</body>
</html>        