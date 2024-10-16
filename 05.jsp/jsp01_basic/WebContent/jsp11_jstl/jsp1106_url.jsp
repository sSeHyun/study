<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>c:url</h1>
	<c:url value="http://search.daum.net/search" var="searchUrl">
		<c:param name="w" value="blog"></c:param>
		<c:param name="q" value="공원"></c:param>
	</c:url>
	<ul>
		<li> ${searchUrl} </li>
		<li><c:url value="jsp1102_if.jsp"></c:url></li>
		<li><c:url value="./jsp1102_if.jsp"></c:url></li>
	</ul>

</body>
</html>