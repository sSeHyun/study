<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>객실목록조회</title>
</head>
<body>
	<div class="container mt-sm-5" align="center">
		<div class="jumbotron">
			<h3>객실리스트조회</h3>
			<c:if test="${ roomList.isEmpty() }">
				<h5><p class="bg-danger text-white">등록된 객실이 없습니다!!!</p></h5>
			</c:if>
		</div>
		
		<form action="roomList.ht" class="form-line">
			<a href="pre_index.jsp" class="btn btn-success col-sm-1 login-btn">메인화면 바로가기</a>
			</div>
		</form>
		<br class="mt-sm-5" />

		<table class="table table-bordered table-striped table-hover">
			<thead class="table-dark" align="center">
				<tr>
					<th width="50%">객실 이름</th>
					<th width="10%">인원</th>
					<th width="40%">객실 타입</th>		
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="room" items="${ roomList }">
				<tr>
					<td>${ roominfo1.getRoom_Id() }</td>
					<td>${ roominfo1.getRoom_peopleCnt() }</td>
					<td>${ roominfo1.getRoom_type() }</td>						
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
	<br />
</body>
</html>