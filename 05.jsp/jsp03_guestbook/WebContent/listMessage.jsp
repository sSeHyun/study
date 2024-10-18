<%@page import="com.lec.service.GetMessageListService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.model.MessageDTO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	GetMessageListService instance = GetMessageListService.getIntance();
	List<MessageDTO> listMessage = instance.getMessageList();
	request.setAttribute("listMessage", listMessage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>실습. 게시판</h1>
	bno(auto) , subject, writer, content, readcnt,crtdate
	list, insert,delete
	
	
	<form action="insertMessage.jsp" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="guest_name" placeholder="이름을 입력하세요..."/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" placeholder="비밀번호를 입력하세요..."/></td>
			</tr>
			<tr>
				<td>방명록</td>
				<td><textarea name="message" rows="5" cols="50" placeholder="방명록을 작성하세요..."></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="방명록등록"/>
				</td>
			</tr>
		</table>
	</form>
	<hr />
	
	<c:if test="${ listMessage.isEmpty() }">
		<h3 style="color: red;">등록된 메시지가 없습니다!!!</h3>
	</c:if> <!-- request.getAttribute("listMessage") -->
	
	
	<c:if test="${ !listMessage.isEmpty() }">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>내용</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="message" items="${ listMessage }">
				<tr>
					<td>${ message.getId() }</td>
					<td>${ message.getGuest_name() }</td>
					<td><textarea rows="5" cols="60" disabled>${ message.getMessage() }</textarea></td>
					<td><a href="deleteMessage.jsp?id=${ message.getId()}">[삭제]</a></td>
				</tr>	
			</c:forEach>		
		</table>
	</c:if>
</body>
</html>














