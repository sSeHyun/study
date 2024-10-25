<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>회원목록조회</title>
</head>
<body>
	<%-- ${ boardList }<br> --%>
	<%-- ${ pageInfo.toString() } --%>
	<div class="container mt-sm-5" align="center">
		<div class="jumbotron">
			<h3>회원목록조회</h3>
			<c:if test="${ memberList.isEmpty() }">
				<h5><p class="bg-danger text-white">등록된 회원이 없습니다!!!</p></h5>
			</c:if>
		</div>
		
		<form action="memberList.mb" class="form-line">
		<div class="input-group">
				<select name="f" id="f" class="form-control col-sm-2 mr-sm-2">
					<option ${ param.f == "id" ? "selected" : ""} value="id">ID</option>
					<option ${ param.f == "name" ? "selected" : ""} value="name">이름</option>
				</select>
				<input type="text" name="q" class="form-control col-sm-8 mr-sm-2" value="${ param.q }"
					placeholder="검색어를 입력하세요!!!"/>
				<button type="submit" class="btn btn-primary col-sm-1 mr-sm-2 login-btn">검색</button>
				<a href="MemberCreateForm.mb?p=${ param.p }" class="btn btn-success col-sm-1 login-btn">회원생성</a>
			</div>
		
		
		</form>
		<br class="mt-sm-5" />
		
		<table class="table table-bordered table-striped table-hover">
			<thead class="table-dark" align="center">
				<tr>
					<th width="10%">회원ID</th>
					<th width="35%">비밀번호</th>
					<th width="10%">이름</th>
					<th width="10%">나이</th>
					<th width="25%">성별</th>
					<th width="10%">이메일</th>				
				</tr>
			</thead>
			<tbody>
			<c:forEach var="member" items="${ memberList }">
				<tr>
					<td align="center">
					<a href="memberDetail.mb?p=${ param.p }&id=${ member.getId() }">${ member.getId() }</a>
					</td>	
					<td align="center">${ member.getPw() }</td>
					<td align="center">${ member.getName() }</td>										
					<td align="center">${ member.getAge() }</td>
					<td align="center">${ member.getGender() }</td>
					<td align="center">${ member.getEmail() }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	
	<div class="container" align="center">
		<ul class="pagination justify-content-center">
			<c:if test="${ pageInfo.getStartPage() != 1 }">
				<li class="page-item page-link"><a href="memberList.mb?p=1"><i class="fas fa-fast-backward"></i></a></li>
				<li class="page-item page-link"><a href="memberList.mb?p=?"${ pageInfo.getStartPage() - 10 }"><i class="fas fa-backward"></i></a></li>			
			</c:if>
		
			<c:forEach var="page_num" begin="${ pageInfo.getStartPage() }" end="${ pageInfo.getEndPage() }">
				<li class="page-item page-link ${ param.p == page_num ? 'bg-warning' : ''}"><a href="memberList.mb?p=${ page_num }">${ page_num }</a></li>
			</c:forEach>
		
			<c:if test="${ pageInfo.getEndPage() < pageInfo.getTotalPage() }">
				<li class="page-item page-link"><a href="memberList.mb?p=${ pageInfo.getStartPage() + 10 }""><i class="fas fa-forward"></i></a></li>
				<li class="page-item page-link"><a href="memberList.mb?p=${ pageInfo.getTotalPage() }"><i class="fas fa-fast-forward"></i></a></li>
			</c:if>
			
		</ul>
	</div>
</body>
</html>