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
			<h3>회원 생성</h3>
			<p>회원정보 생성 페이지 입니다!! 회원정보를 작성해 주세요!!</p>
		</div>	
		
		<form action="memberCreate.mb" method="post"  name="memberForm">
			
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
				<input type="text" class="form-control" name="id" id="id" value="hong" required placeholder="ID를 입력하세요"/>
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-key"></i></span></div>
				<input type="password" class="form-control" name="pw" id="pw" value="12345" required placeholder="비밀번호를 입력하세요..."/>
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="name" id="name" value="홍길동" required placeholder="이름을 입력하세요..."/>
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="age" id="age" value="999" required placeholder="나이를 입력하세요..."/>
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="gender" id="gender" value="남성" required placeholder="성별을 입력하세요..."/>
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="email" id="email" value="hong@gmail.com" required placeholder="xxx@abcde.com"/>
			</div>
	
				<div class="form-group input-group mt-md-5 justify-content-center">
					<input type="submit" class="btn btn-success float-right login-btn" value="회원등록"/>
					<input type="reset" class="btn btn-success float-right login-btn ml-sm-2" value="새로고침"/>
				</div>			
			</div>		
		</form>
	</div>
</body>
</html>










