<%@page import="net.sourceforge.jdatepicker.JDatePicker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/button_style.css" />

<title>Insert title here</title>
</head>
<body>

<div class="container mt-sm-5" align="center">
		<div class="jumbotron">
			<h3>객실 예약페이지</h3>
		</div>
		
	<div class="form-group input-group">
			<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
			<input type="text" class="form-control" name="room_id" id="room_id" value="${ room.getRoom_id() }" readonly/>
	</div>
	
	<div>	
		<button type="button" onclick="location.href='RoomPickDate.ht' ">일정선택</button>
	</div>
	
</div>	
</body>
</html>