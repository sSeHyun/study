<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/button_style.css" />
<title></title>
</head>
<body>

	<div class="container mt-sm-5" align="center">
		<div class="jumbotron">
			<h3>회원정보수정하기</h3>
			<p>회원정보를 수정하는 서비스입니다!!!</p>
		</div>
		
		<form action="memberModify.do" method="post" name="memberForm" >
			<input type="hidden" name="p" value="${ param.p }"/>
			<input type="hidden" name="id" value="${ member.getId() }"/>
			
		<div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
			<input type="text" class="form-control" name="id" id="id" value="${ member.getId() }" readonly/>
		</div>	
				
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-key"></i></span></div>
				<input type="password" class="form-control" name="pw" id="pw" value="12345" required placeholder="비밀번호를 입력하세요..."/>
			</div>
								
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="name" id="name" value="${ member.getName() }"/>
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="age" id="age" value="${ member.getAge() }"/>
			</div>
			
			
			
				
				<div class="form-group input-group mt-md-5 justify-content-center">
					<input type="submit" class="btn btn-success float-right login-btn" value="게시글수정"/>
					<input type="reset" class="btn btn-success float-right login-btn ml-sm-2" value="새로고침"/>
					<a href="javascript:history.go(-1)" class="btn btn-success ml-sm-2 float-right">이전</a>
				</div>				
			</div>		
		</form>
	</div>
		
</body>
</html>