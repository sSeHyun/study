<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
			<h3>객실조회</h3>
			<c:if test="${ roomList.isEmpty() }">
				<h5><p class="bg-danger text-white">등록된 객실이 없습니다!!!</p></h5>
			</c:if>
		</div>
		
		<form action="roomList.ht" class="form-line">
			<div class="input-group">
				<select name="f" id="f" class="form-control col-sm-2 mr-sm-2">
					<option ${ param.f == "room_id" ? "selected" : ""} value="room_id">방이름</option>
					<option ${ param.f == "room_type" ? "selected" : ""} value="room_type">룸타입</option>
				</select>
				<input type="text" name="q" class="form-control col-sm-8 mr-sm-2" value="${ param.q }"
					placeholder="검색어를 입력하세요!!!"/>
				<button type="submit" class="btn btn-primary col-sm-1 mr-sm-2 login-btn">검색</button>
				<a href="pre_index.jsp" class="btn btn-success col-sm-1 login-btn">메인</a>
			</div>
			</div>
		</form>
		<br class="mt-sm-5" />

		<table class="table table-bordered table-striped table-hover">
			<thead class="table-dark" align="center">
				<tr>
					<th width="50%">객실타입</th>
					<th width="10%">인원</th>
					<th width="10%">가격</th>
				
				</tr>
			</thead>
			<tbody>
			<c:forEach var="room" items="${ roomList }">
				<tr>		
					<td><a href="roomDetail.ht?p=${ param.p }&room_id=${  room.getRoom_id() }">${  room.getRoom_id() }</a></td>
					<td>${ room.getRoom_peopleCnt() }</td>				
					<td>&#8361; <fmt:formatNumber value="${ room.getRoom_price() }" type="number" groupingUsed="true"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<br />
	
	<div class="container" align="center">
		<ul class="pagination justify-content-center">
			<c:if test="${ pageInfo.getStartPage() != 1 }">
				<li class="page-item page-link"><a href="roomList.ht?p=1"><i class="fas fa-fast-backward"></i></a></li>
				<li class="page-item page-link"><a href="roomList.ht?p=${ pageInfo.getStartPage() - 10 }"><i class="fas fa-backward"></i></a></li>			
			</c:if>
		
			<c:forEach var="page_num" begin="${ pageInfo.getStartPage() }" end="${ pageInfo.getEndPage() }">
				<li class="page-item page-link ${ param.p == page_num ? 'bg-warning' : ''}"><a href="roomList.ht?p=${ page_num }">${ page_num }</a></li>
			</c:forEach>
		
			<c:if test="${ pageInfo.getEndPage() < pageInfo.getTotalPage() }">
				<li class="page-item page-link"><a href="roomList.ht?p=${ pageInfo.getStartPage() + 10 }""><i class="fas fa-forward"></i></a></li>
				<li class="page-item page-link"><a href="roomList.ht?p=${ pageInfo.getTotalPage() }"><i class="fas fa-fast-forward"></i></a></li>
			</c:if>
			
		</ul>
	</div>
	
</body>
</html>