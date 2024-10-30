<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
crossorigin="anonymous">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="./css/button_style.css" />
<title>Login</title>
</head>
<body>
<div class="container mt-sm-5" align="center">
		<div class="jumbotron">
			<h3>로그인</h3>
			<p>로그인 페이지 입니다. 아이디와 비밀번호를 입력해 주세요!!</p>
		</div>
    <form action="customerLogin.cs" method="post" name="customerLoginForm">

        <div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
			<input type="text" class="form-control" name="customer_id" id="customer_id"  required placeholder="ID를 입력하세요"/>
		</div>
	
		<div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-key"></i></span></div>
			<input type="password" class="form-control" name="customer_pw" id="customer_pw" required placeholder="비밀번호를 입력하세요..."/>
		</div>
        
        <div class="form-group input-group mt-md-5 justify-content-center">
			<input type="submit" class="btn btn-success float-right login-btn" value="로그인"/>
			<input type="reset" class="btn btn-success float-right login-btn ml-sm-2" value="새로고침"/>
		</div>			
    </form>
</body>
</html>
