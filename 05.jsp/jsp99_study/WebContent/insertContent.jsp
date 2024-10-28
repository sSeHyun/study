<%@page import="com.lec.service.WriteContentService"%>
<%@page import="com.lec.model.ContentDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
	ContentDTO content=new ContentDTO();
	
	content.setSubject(request.getParameter("subject"));
	content.setWriter(request.getParameter("writer"));
	content.setContent(request.getParameter("content"));
	
	WriteContentService writeService = WriteContentService.getInstance();
	writeService.write(content);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>게시글 등록성공!</h1>
	<%--
	<%=content.getSubject()%> <br />
	<%=content.getWriter() %> <br />
	<%=content.getContent()%> <br />
	 --%>
	
	게시글이 성공적으로 등록되었습니다!!<br>
	<a href="listContent.jsp">[목록보기]</a>
</body>
</html>
