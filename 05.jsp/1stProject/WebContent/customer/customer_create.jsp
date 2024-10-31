<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="./css/button_style.css" />
<title>회원생성</title>
</head>
<body>
	
	<div class="container" align="center">
		<div class="jumbotron">
			<h3>회원 가입</h3>
			<p>회원가입 페이지 입니다!! 회원정보를 작성해 주세요!!</p>
		</div>	
		
		<form action="customerCreate.cs" method="post"  name="customerForm">
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
				<input type="text" class="form-control" name="customer_id" id="customer_id" value="hong" required placeholder="ID를 입력하세요"/>
			</div>
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-key"></i></span></div>
				<input type="password" class="form-control" name="customer_pw" id="customer_pw" value="1234"  required placeholder="비밀번호를 입력하세요..."/>
			</div>
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="customer_name" id="customer_name"  value="홍길동" required placeholder="이름을 입력하세요..."/>
			</div>
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="customer_jumin" id="customer_jumin" value="123456-1234567"  required placeholder="주민등록번호를 입력하세요..."/>
			</div>
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="customer_phone" id="customer_phone" value="010-1234-5678"  required placeholder="핸드폰 번호를 입력하세요..."/>
			</div>
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="customer_addr" id="customer_addr"  value="서울시 강남구"  required placeholder="서울시 강남구"/>
			</div>
			
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="customer_email" id="customer_email"  value="xxx@abcde.com" required placeholder="xxx@abcde.com"/>
			</div>
			
			<div class="form-group input-group mt-md-5 justify-content-center">
					<input type="submit" class="btn btn-success float-right login-btn" value="회원등록"/>
					<input type="reset" class="btn btn-success float-right login-btn ml-sm-2" value="새로고침"/>
			</div>		
				
		</form>
	</div>		
	
</body>
</html>










