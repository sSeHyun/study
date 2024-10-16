<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

	Map<String,Object> map=new HashMap<>();
	map.put("name","홍길동");
	map.put("today",new java.util.Date());
	//request.setAttribute("data",map);
	
%>
<c:set var="data" value ="<%= map %>" /> <!-- request.setAttribute("data", map)동일 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>forEach - Map</h1>
	
	<c:forEach var="m" items="${ data }">
		${ m.key } = ${ m.value }<br>
	</c:forEach>
	
	<h1>1~10까지의합 </h1>
	<!-- for(int i=0;i<=10;i++){}  -->
	<c:set var="sum" value="0"/>	<!-- request.setAttribute("sum",0)과 동일 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:set var="sum" value="${sum+i}"/>	
		${i}=${sum}
	</c:forEach>
		<h3>1~10까지의 합은: ${sum}</h3>
		
		<hr />
	
	<!-- 실습. 1~100까지 홀수의 합 -->
	<h1>1~100까지의 홀수 합</h1>
	<c:set var="sum1" value="0"/>
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum1" value="${sum1+i}"/>
		${i}번의 합=${sum1} <br />
	</c:forEach>
		<h3>1~100까지의 홀수 합: ${sum1}</h3>
	
	
	<hr />
	<!-- 실습. int[] {1,2,3,4,5,6,7,8,9,10} 배열의 합 -->
	<h1>int[]{1,2,3,4,5,6,7,8,9,10} 배열의 합</h1>

	
	<c:set var="sum2" value="0"/>
	<c:set var="intArray" value="<%= new int[] {1,2,3,4,5,6,7,8,9,10} %>"/>
	
	<c:forEach var="i" items="${intArray}">	
	<c:set var="sum2" value="${sum+intArray[i]}"/>		
	</c:forEach>
	
	<h3>int[] {1,2,3,4,5,6,7,8,9,10} 배열의 합: ${sum2}</h3>

	<hr />
	
	<h1>실습. int[] {1,2,3,4,5,6,7,8,9,10} 즉, int배열의 합?</h1>
	<c:set var="sum" value="0"/>
	<c:set var="intArray" value="<%= new int[] {1,2,3,4,5,6,7,8,9,10} %>"/>
	<c:forEach var="i" items="${ intArray }">
 		<c:set var="sum" value="${ sum + intArray[i] }"/>
	</c:forEach>
	<hr />
	
	<c:set var="sum" value="0"/>

	<c:forEach var="i" items="${ intArray }" begin="2" end="4" varStatus="status">
 		${ status.index } - ${ status.count } - [${i}]<br>
	</c:forEach>
</body>
</html>
















