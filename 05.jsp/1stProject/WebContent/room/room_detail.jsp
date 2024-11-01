<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/button_style.css" />

<title>객실 상세 보기 / 예약 </title>
</head>
<body>
<%
	


%>
<div class="container mt-sm-5" align="center">
		<div class="jumbotron">
		<h3>객실 상세보기</h3>
		</div>
		
		<div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
			<input type="text" class="form-control" name="room_id" id="room_id" value="${ room.getRoom_id() }" readonly/>
		</div>	
			
		<div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
			<input type="text" class="form-control" name="room_peopleCnt" id="room_peopleCnt" value="${ room.getRoom_peopleCnt() }" readonly/>
		</div>		
		
		<div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
			<input type="text" class="form-control" name="room_type" id="room_type" value="${ room.getRoom_type() }" readonly/>
		</div>		
		
		<div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
			<input type="text" class="form-control" name="room_price" id="room_price" value="${ room.getRoom_price() }" readonly/>
		</div>	
			
		<br />
		
		<div class="form-group input-group">
			<a href="roomList.ht?p=${ param.p }" class="btn btn-success mr-sm-3 login-btn">뒤로가기</a>
			<a href="roomReservation.ht?room_id=${ room.getRoom_id() }" class="btn btn-success mr-sm-3 login-btn">예약하기</a>
		</div>
	</div>
</body>
</html>