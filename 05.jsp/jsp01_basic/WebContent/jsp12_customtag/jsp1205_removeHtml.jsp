<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>HTML TAG 삭제하기</h1>
	<c:set var="dataEL" value="<%=new java.util.Date() %>"/>
	<font size="10">현재시간은 ${dataEL} </font>
	
	<tf:removeHtml trim="true">
		<font size="10">현재시간은 ${dataEL} </font>
	</tf:removeHtml>
	<br />
	
	

</body>
</html>